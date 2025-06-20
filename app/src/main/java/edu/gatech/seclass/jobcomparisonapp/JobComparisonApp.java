package edu.gatech.seclass.jobcomparisonapp;

import java.util.ArrayList;
import java.util.List;

public class JobComparisonApp {
    private Job currentJob;
    private List<Job> jobOffers;
    private ComparisonSetting settings;

    public JobComparisonApp() {
        jobOffers = new ArrayList<>();
        settings = new ComparisonSetting(1, 1, 1, 1, 1); // Default weights
    }

    public void updateCurrentJob(Job job) {
        this.currentJob = job;
    }

    public void updateJobOffers(List<Job> offers) {
        this.jobOffers = offers;
    }

    public void adjustSettings(ComparisonSetting settings) {
        this.settings = settings;
    }

    public boolean compareEnabled() {
        return currentJob != null && !jobOffers.isEmpty();
    }

    public void compareJobs() {
        JobComparator comparator = new JobComparator();
        for (Job offer : jobOffers) {
            ComparisonResult result = comparator.compare(currentJob, offer, settings);
            // In a real app, you would store or display the result here.
        }
    }
}
