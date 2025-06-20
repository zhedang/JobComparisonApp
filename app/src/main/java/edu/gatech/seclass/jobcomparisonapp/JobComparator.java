package edu.gatech.seclass.jobcomparisonapp;

import java.math.BigDecimal;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class JobComparator {

    public ComparisonResult compare(Job job1, Job job2, ComparisonSetting settings) {
        BigDecimal score1 = calculateScore(job1, settings);
        BigDecimal score2 = calculateScore(job2, settings);
        Job better = (score1.compareTo(score2) >= 0) ? job1 : job2;
        return new ComparisonResult(score1, score2, better);
    }

    public List<Job> rankJobs(List<Job> jobs, ComparisonSetting settings) {
        return jobs.stream()
                .sorted(Comparator.comparing((Job job) -> calculateScore(job, settings)).reversed())
                .collect(Collectors.toList());
    }

    private BigDecimal calculateScore(Job job, ComparisonSetting settings) {
        BigDecimal AYS = job.getAdjustedYearlySalary();
        BigDecimal AYB = job.getAdjustedYearlyBonus();
        BigDecimal RA = job.getEffectiveRelocationAllowance();
        BigDecimal WS = job.getEffectiveWellnessStipend();
        BigDecimal DI = job.getDentalInsurance();

        int totalWeight = settings.getYearlySalaryWeight() + settings.getYearlyBonusWeight()
                + settings.getRelocationAllowanceWeight() + settings.getWellnessFundWeight()
                + settings.getDentalInsuranceWeight();

        BigDecimal score = BigDecimal.ZERO;
        score = score.add(AYS.multiply(new BigDecimal(settings.getYearlySalaryWeight())));
        score = score.add(AYB.multiply(new BigDecimal(settings.getYearlyBonusWeight())));
        score = score.add(RA.multiply(new BigDecimal(settings.getRelocationAllowanceWeight())));
        score = score.add(WS.multiply(new BigDecimal(settings.getWellnessFundWeight())));
        score = score.add(DI.multiply(new BigDecimal(settings.getDentalInsuranceWeight())));

        return score.divide(new BigDecimal(totalWeight), 2, BigDecimal.ROUND_HALF_UP);
    }
}
