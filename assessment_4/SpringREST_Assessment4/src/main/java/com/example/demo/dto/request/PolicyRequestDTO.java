package com.example.demo.dto.request;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
public class PolicyRequestDTO {
    @NotBlank
    private String policyNumber;
    private String policyType;
    @Positive
    private double premiumAmount;
    @Positive
    private double coverageAmount;
    @NotNull
    private LocalDate startDate;
    private LocalDate endDate;
    private Long customerId;
    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyType() { return policyType; }
    public double getPremiumAmount() { return premiumAmount; }
    public double getCoverageAmount() { return coverageAmount; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public Long getCustomerId() { return customerId; }

    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public void setPolicyType(String policyType) { this.policyType = policyType; }
    public void setPremiumAmount(double premiumAmount) { this.premiumAmount = premiumAmount; }
    public void setCoverageAmount(double coverageAmount) { this.coverageAmount = coverageAmount; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}