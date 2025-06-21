package edu.gatech.seclass.jobcomparisonapp;

import java.math.BigDecimal;

public class JobComparator {

    public ScoredJob scoreJob(String label, Job job, ComparisonSetting settings) {
        BigDecimal AYS = job.getAdjustedYearlySalary();
        BigDecimal AYB = job.getAdjustedYearlyBonus();

        // All calculation logic is now centralized here
        BigDecimal effectiveRA = job.getRelocationAllowance().add(AYS.multiply(new BigDecimal("0.05")));
        BigDecimal effectiveWS = job.getWellnessFund().add(AYB.multiply(new BigDecimal("0.10")));
        BigDecimal DI = job.getDentalInsurance();

        BigDecimal score = calculateScore(AYS, AYB, effectiveRA, effectiveWS, DI, settings);

        return new ScoredJob(label, job, score, AYS, AYB, effectiveRA, effectiveWS);
    }

    private BigDecimal calculateScore(BigDecimal AYS, BigDecimal AYB, BigDecimal RA, BigDecimal WS, BigDecimal DI, ComparisonSetting settings) {
        int totalWeight = settings.getYearlySalaryWeight() + settings.getYearlyBonusWeight()
                + settings.getRelocationAllowanceWeight() + settings.getWellnessFundWeight()
                + settings.getDentalInsuranceWeight();

        if (totalWeight == 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal score = BigDecimal.ZERO;
        score = score.add(AYS.multiply(new BigDecimal(settings.getYearlySalaryWeight())));
        score = score.add(AYB.multiply(new BigDecimal(settings.getYearlyBonusWeight())));
        score = score.add(RA.multiply(new BigDecimal(settings.getRelocationAllowanceWeight())));
        score = score.add(WS.multiply(new BigDecimal(settings.getWellnessFundWeight())));
        score = score.add(DI.multiply(new BigDecimal(settings.getDentalInsuranceWeight())));

        return score.divide(new BigDecimal(totalWeight), 2, BigDecimal.ROUND_HALF_UP);
    }
}
