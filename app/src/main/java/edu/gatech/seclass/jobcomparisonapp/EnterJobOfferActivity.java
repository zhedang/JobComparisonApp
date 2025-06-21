// File: EnterJobOfferActivity.java
package edu.gatech.seclass.jobcomparisonapp;

public class EnterJobOfferActivity extends BaseJobEntryActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_enter_job_offer;
    }

    @Override
    protected String getSuccessMessage() {
        return "Job Offer Saved";
    }

    @Override
    protected void saveJob(Job job) {
        MainActivity.jobApp.addJobOffer(job);
    }
}