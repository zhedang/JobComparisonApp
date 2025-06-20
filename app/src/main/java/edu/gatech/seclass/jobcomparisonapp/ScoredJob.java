// File: ScoredJob.java
package edu.gatech.seclass.jobcomparisonapp;

import java.io.Serializable;
import java.math.BigDecimal;

public class ScoredJob implements Serializable {
    public String label;
    public Job job;
    public BigDecimal score;

    public ScoredJob(String label, Job job, BigDecimal score) {
        this.label = label;
        this.job = job;
        this.score = score;
    }
}