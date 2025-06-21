// File: ScoredJob.java
package edu.gatech.seclass.jobcomparisonapp;

import java.io.Serializable;
import java.math.BigDecimal;

public class ScoredJob implements Serializable {
    public final String label;
    public final Job job;
    public final BigDecimal score;
    public final BigDecimal adjustedYearlySalary;
    public final BigDecimal adjustedYearlyBonus;
    public final BigDecimal effectiveRelocationAllowance;
    public final BigDecimal effectiveWellnessStipend;

    public ScoredJob(String label, Job job, BigDecimal score, BigDecimal adjustedYearlySalary,
                       BigDecimal adjustedYearlyBonus, BigDecimal effectiveRelocationAllowance,
                       BigDecimal effectiveWellnessStipend) {
        this.label = label;
        this.job = job;
        this.score = score;
        this.adjustedYearlySalary = adjustedYearlySalary;
        this.adjustedYearlyBonus = adjustedYearlyBonus;
        this.effectiveRelocationAllowance = effectiveRelocationAllowance;
        this.effectiveWellnessStipend = effectiveWellnessStipend;
    }
}