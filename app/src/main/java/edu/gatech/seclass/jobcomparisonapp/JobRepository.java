// File: JobRepository.java
package edu.gatech.seclass.jobcomparisonapp;

import java.util.ArrayList;
import java.util.List;

public class JobRepository {
    private static final JobRepository instance = new JobRepository();

    private List<ScoredJob> scoredJobs = new ArrayList<>();

    private JobRepository() {}

    public static JobRepository getInstance() {
        return instance;
    }

    public List<ScoredJob> getScoredJobs() {
        return scoredJobs;
    }

    public void setScoredJobs(List<ScoredJob> jobs) {
        this.scoredJobs = jobs;
    }
}