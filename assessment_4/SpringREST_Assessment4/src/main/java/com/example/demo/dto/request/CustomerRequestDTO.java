package com.example.demo.dto.request;
import jakarta.validation.constraints.*;
public class CustomerRequestDTO {
    @NotBlank
    private String name;
    @Email
    private String email;
    private String phoneNumber;
    private String address;
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setAddress(String address) { this.address = address; }
}