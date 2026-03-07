package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String policyNumber;
    private String policyType;
    private double premiumAmount;
    private double coverageAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    public Policy() {}
    public Long getId() { return id; }
    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyType() { return policyType; }
    public double getPremiumAmount() { return premiumAmount; }
    public double getCoverageAmount() { return coverageAmount; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getStatus() { return status; }
    public Customer getCustomer() { return customer; }
    public void setId(Long id) { this.id = id; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public void setPolicyType(String policyType) { this.policyType = policyType; }
    public void setPremiumAmount(double premiumAmount) { this.premiumAmount = premiumAmount; }
    public void setCoverageAmount(double coverageAmount) { this.coverageAmount = coverageAmount; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setStatus(String status) { this.status = status; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}