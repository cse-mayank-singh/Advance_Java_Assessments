package com.example.demo.service;
import com.example.demo.dto.request.PolicyRequestDTO;
import com.example.demo.dto.response.PolicyResponseDTO;
import org.springframework.data.domain.Page;
import java.util.List;
public interface PolicyService {
    PolicyResponseDTO createPolicy(PolicyRequestDTO dto);
    List<PolicyResponseDTO> getAllPolicies();
    PolicyResponseDTO getPolicyById(Long id);
    PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto);
    void cancelPolicy(Long id);
    List<PolicyResponseDTO> getPoliciesByType(String type);
    List<PolicyResponseDTO> getPoliciesByPremiumRange(double min,double max);
    Page<PolicyResponseDTO> getPoliciesWithPagination(int page,int size,String sortBy,String direction);
}