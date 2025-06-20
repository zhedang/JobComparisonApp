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

    public void setCurrentJob(Job job) {
        this.currentJob = job;
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void addJobOffer(Job jobOffer) {
        this.jobOffers.add(jobOffer);
    }

    public List<Job> getJobOffers() {
        return jobOffers;
    }

    public void adjustSettings(ComparisonSetting settings) {
        this.settings = settings;
    }

    public ComparisonSetting getSettings() {
        return settings;
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
