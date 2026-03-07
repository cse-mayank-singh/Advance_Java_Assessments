package com.example.demo.mapper;
import com.example.demo.entity.Customer;
import com.example.demo.dto.request.CustomerRequestDTO;
import com.example.demo.dto.response.CustomerResponseDTO;
public class CustomerMapper {
    public static Customer toEntity(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setAddress(dto.getAddress());
        return customer;
    }
    public static CustomerResponseDTO toDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setAddress(customer.getAddress());
        return dto;
    }
}