// File: CompareJobsActivity.java
package edu.gatech.seclass.jobcomparisonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.math.BigDecimal;

public class CompareJobsActivity extends AppCompatActivity {

    private ListView jobListView;
    private ArrayList<String> jobList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_jobs);

        jobListView = findViewById(R.id.jobListView);
        jobList = new ArrayList<>();

        List<ScoredJob> scoredJobs = new ArrayList<>();

        // Load current job
        if (MainActivity.jobApp.getCurrentJob() != null) {
            Job currentJob = MainActivity.jobApp.getCurrentJob();
            BigDecimal score = calculateScore(currentJob);
            scoredJobs.add(new ScoredJob("Current Job", currentJob, score));
        }

        // Load offers
        List<Job> offers = MainActivity.jobApp.getJobOffers();
        for (int i = 0; i < offers.size(); i++) {
            Job job = offers.get(i);
            BigDecimal score = calculateScore(job);
            scoredJobs.add(new ScoredJob("Offer " + (i + 1), job, score));
        }

        // Sort from highest score to lowest
        Collections.sort(scoredJobs, (a, b) -> b.score.compareTo(a.score));

        // Display list
        for (ScoredJob sj : scoredJobs) {
            jobList.add(sj.label + ": " + sj.job.getTitle() + " at " + sj.job.getCompany()
                    + " (" + sj.job.getLocation().getCity() + ", " + sj.job.getLocation().getState() + ") - Score: " + sj.score);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jobList);
        jobListView.setAdapter(adapter);

        jobListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedJob = jobList.get(position);
            Toast.makeText(CompareJobsActivity.this, "Selected: " + selectedJob, Toast.LENGTH_SHORT).show();
            // TODO: Future step - open detailed comparison view
        });
    }

    private BigDecimal calculateScore(Job job) {
        ComparisonSetting setting = MainActivity.jobApp.getSettings();

        BigDecimal AYS = job.getAdjustedYearlySalary();
        BigDecimal AYB = job.getAdjustedYearlyBonus();
        BigDecimal RA = job.getRelocationAllowance().add(AYS.multiply(new BigDecimal("0.05")));
        BigDecimal WS = job.getWellnessFund().add(AYB.multiply(new BigDecimal("0.10")));
        BigDecimal DI = job.getDentalInsurance();

        int totalWeight = setting.getYearlySalaryWeight() + setting.getYearlyBonusWeight() + setting.getRelocationAllowanceWeight()
                + setting.getWellnessFundWeight() + setting.getDentalInsuranceWeight();

        BigDecimal score =
                AYS.multiply(new BigDecimal(setting.getYearlySalaryWeight()))
                        .add(AYB.multiply(new BigDecimal(setting.getYearlyBonusWeight())))
                        .add(RA.multiply(new BigDecimal(setting.getRelocationAllowanceWeight())))
                        .add(WS.multiply(new BigDecimal(setting.getWellnessFundWeight())))
                        .add(DI.multiply(new BigDecimal(setting.getDentalInsuranceWeight())));

        return score.divide(new BigDecimal(totalWeight), 2, BigDecimal.ROUND_HALF_UP);
    }

    private static class ScoredJob {
        String label;
        Job job;
        BigDecimal score;

        ScoredJob(String label, Job job, BigDecimal score) {
            this.label = label;
            this.job = job;
            this.score = score;
        }
    }
}
