package edu.gatech.seclass.jobcomparisonapp;

import java.math.BigDecimal;

public class ComparisonResult {
    private BigDecimal job1Score;
    private BigDecimal job2Score;
    private Job betterJob;

    public ComparisonResult(BigDecimal job1Score, BigDecimal job2Score, Job betterJob) {
        this.job1Score = job1Score;
        this.job2Score = job2Score;
        this.betterJob = betterJob;
    }

    public BigDecimal getJob1Score() { return job1Score; }
    public BigDecimal getJob2Score() { return job2Score; }
    public Job getBetterJob() { return betterJob; }
}