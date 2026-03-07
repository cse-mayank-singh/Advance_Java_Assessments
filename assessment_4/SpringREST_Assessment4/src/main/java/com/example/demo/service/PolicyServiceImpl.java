package com.example.demo.service;
import com.example.demo.dto.request.PolicyRequestDTO;
import com.example.demo.dto.response.PolicyResponseDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Policy;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.PolicyNotFoundException;
import com.example.demo.mapper.PolicyMapper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PolicyRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PolicyServiceImpl implements PolicyService {
    private final PolicyRepository policyRepository;
    private final CustomerRepository customerRepository;
    public PolicyServiceImpl(PolicyRepository policyRepository,
                             CustomerRepository customerRepository) {
        this.policyRepository = policyRepository;
        this.customerRepository = customerRepository;
    }
    @Override
    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        Policy policy = new Policy();
        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        policy.setStatus("ACTIVE");
        policy.setCustomer(customer);
        Policy savedPolicy = policyRepository.save(policy);
        return PolicyMapper.toDTO(savedPolicy);
    }
    @Override
    public List<PolicyResponseDTO> getAllPolicies() {
        return policyRepository.findAll()
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public PolicyResponseDTO getPolicyById(Long id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));
        return PolicyMapper.toDTO(policy);
    }
    @Override
    public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        Policy updated = policyRepository.save(policy);
        return PolicyMapper.toDTO(updated);
    }
    @Override
    public void cancelPolicy(Long id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));
        policy.setStatus("CANCELLED");
        policyRepository.save(policy);
    }
    @Override
    public List<PolicyResponseDTO> getPoliciesByType(String type) {
        return policyRepository.findByPolicyType(type)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(double min,double max) {
        return policyRepository.findByPremiumAmountBetween(min,max)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public Page<PolicyResponseDTO> getPoliciesWithPagination(int page,int size,String sortBy,String direction) {
        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return policyRepository.findAll(pageable)
                .map(PolicyMapper::toDTO);
    }
}