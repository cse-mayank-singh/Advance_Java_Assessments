package com.example.demo.controller;
import com.example.demo.dto.request.PolicyRequestDTO;
import com.example.demo.dto.response.PolicyResponseDTO;
import com.example.demo.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    private final PolicyService policyService;
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }
    @PostMapping
    public PolicyResponseDTO createPolicy(
            @Valid @RequestBody PolicyRequestDTO dto) {
        return policyService.createPolicy(dto);
    }
    @GetMapping
    public List<PolicyResponseDTO> getAllPolicies() {
        return policyService.getAllPolicies();
    }
    @GetMapping("/{id}")
    public PolicyResponseDTO getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }
    @PutMapping("/{id}")
    public PolicyResponseDTO updatePolicy(
            @PathVariable Long id,
            @RequestBody PolicyRequestDTO dto) {
        return policyService.updatePolicy(id,dto);
    }

    @DeleteMapping("/{id}")
    public String cancelPolicy(@PathVariable Long id) {

        policyService.cancelPolicy(id);
        return "Policy cancelled successfully";
    }
    @GetMapping("/type/{type}")
    public List<PolicyResponseDTO> getPoliciesByType(@PathVariable String type) {
        return policyService.getPoliciesByType(type);
    }
    @GetMapping("/premium")
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(
            @RequestParam double min,
            @RequestParam double max) {
        return policyService.getPoliciesByPremiumRange(min,max);
    }
    @GetMapping("/paged")
    public Page<PolicyResponseDTO> getPoliciesWithPagination(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String direction) {
        return policyService.getPoliciesWithPagination(page,size,sortBy,direction);
    }
}