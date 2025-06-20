// File: ComparisonResult.java
package edu.gatech.seclass.jobcomparisonapp;

import java.io.Serializable;
import java.math.BigDecimal;

public class ComparisonResult implements Serializable {
    private BigDecimal score1;
    private BigDecimal score2;
    private Job betterJob;

    public ComparisonResult(BigDecimal score1, BigDecimal score2, Job betterJob) {
        this.score1 = score1;
        this.score2 = score2;
        this.betterJob = betterJob;
    }

    public BigDecimal getScore1() { return score1; }
    public BigDecimal getScore2() { return score2; }
    public Job getBetterJob() { return betterJob; }
}