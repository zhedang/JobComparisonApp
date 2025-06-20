package edu.gatech.seclass.jobcomparisonapp;

import java.math.BigDecimal;

public class Job {
    private String title;
    private String company;
    private Location location;
    private BigDecimal yearlySalary;
    private BigDecimal yearlyBonus;
    private BigDecimal wellnessFund;
    private BigDecimal dentalInsurance;
    private BigDecimal relocationAllowance;

    public Job(String title, String company, Location location, BigDecimal yearlySalary, BigDecimal yearlyBonus,
               BigDecimal wellnessFund, BigDecimal dentalInsurance, BigDecimal relocationAllowance) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.wellnessFund = wellnessFund;
        this.dentalInsurance = dentalInsurance;
        this.relocationAllowance = relocationAllowance;
    }

    public BigDecimal getAdjustedYearlySalary() {
        return yearlySalary.multiply(new BigDecimal(100)).divide(new BigDecimal(location.getCostOfLiving()));
    }

    public BigDecimal getAdjustedYearlyBonus() {
        return yearlyBonus.multiply(new BigDecimal(100)).divide(new BigDecimal(location.getCostOfLiving()));
    }

    public BigDecimal getEffectiveRelocationAllowance() {
        return relocationAllowance.add(getAdjustedYearlySalary().multiply(new BigDecimal("0.05")));
    }

    public BigDecimal getEffectiveWellnessStipend() {
        return wellnessFund.add(getAdjustedYearlyBonus().multiply(new BigDecimal("0.10")));
    }

    public String getTitle() { return title; }
    public String getCompany() { return company; }
    public Location getLocation() { return location; }
    public BigDecimal getYearlySalary() { return yearlySalary; }
    public BigDecimal getYearlyBonus() { return yearlyBonus; }
    public BigDecimal getWellnessFund() { return wellnessFund; }
    public BigDecimal getDentalInsurance() { return dentalInsurance; }
    public BigDecimal getRelocationAllowance() { return relocationAllowance; }
}