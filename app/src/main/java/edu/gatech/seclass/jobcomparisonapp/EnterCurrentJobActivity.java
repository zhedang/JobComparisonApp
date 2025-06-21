// File: EnterCurrentJobActivity.java
package edu.gatech.seclass.jobcomparisonapp;

public class EnterCurrentJobActivity extends BaseJobEntryActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_enter_current_job;
    }

    @Override
    protected String getSuccessMessage() {
        return "Current Job Saved";
    }

    @Override
    protected void saveJob(Job job) {
        MainActivity.jobApp.setCurrentJob(job);
    }
}