package edu.gatech.seclass.jobcomparisonapp;

public class ComparisonSetting {
    private int yearlySalaryWeight;
    private int yearlyBonusWeight;
    private int relocationAllowanceWeight;
    private int wellnessFundWeight;
    private int dentalInsuranceWeight;

    public ComparisonSetting(int yearlySalaryWeight, int yearlyBonusWeight, int relocationAllowanceWeight, int wellnessFundWeight, int dentalInsuranceWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
        this.yearlyBonusWeight = yearlyBonusWeight;
        this.relocationAllowanceWeight = relocationAllowanceWeight;
        this.wellnessFundWeight = wellnessFundWeight;
        this.dentalInsuranceWeight = dentalInsuranceWeight;
    }

    public int getYearlySalaryWeight() { return yearlySalaryWeight; }
    public int getYearlyBonusWeight() { return yearlyBonusWeight; }
    public int getRelocationAllowanceWeight() { return relocationAllowanceWeight; }
    public int getWellnessFundWeight() { return wellnessFundWeight; }
    public int getDentalInsuranceWeight() { return dentalInsuranceWeight; }
}
