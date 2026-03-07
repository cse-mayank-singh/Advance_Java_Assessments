package com.example.demo.service;
import com.example.demo.dto.request.CustomerRequestDTO;
import com.example.demo.dto.response.CustomerResponseDTO;
import java.util.List;
public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO dto);
    List<CustomerResponseDTO> getAllCustomers();
    CustomerResponseDTO getCustomerById(Long id);
}