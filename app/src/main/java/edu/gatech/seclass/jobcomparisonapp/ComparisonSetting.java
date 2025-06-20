package edu.gatech.seclass.jobcomparisonapp;

public class ComparisonSetting {
    private int yearlySalary;
    private int yearlyBonus;
    private int relocationAllowance;
    private int wellnessFund;
    private int dentalInsurance;

    public ComparisonSetting(int yearlySalary, int yearlyBonus, int relocationAllowance, int wellnessFund, int dentalInsurance) {
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.relocationAllowance = relocationAllowance;
        this.wellnessFund = wellnessFund;
        this.dentalInsurance = dentalInsurance;
    }

    public int getYearlySalary() { return yearlySalary; }
    public int getYearlyBonus() { return yearlyBonus; }
    public int getRelocationAllowance() { return relocationAllowance; }
    public int getWellnessFund() { return wellnessFund; }
    public int getDentalInsurance() { return dentalInsurance; }
}
