// File: CompareJobsActivity.java
package edu.gatech.seclass.jobcomparisonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.math.BigDecimal;

public class CompareJobsActivity extends AppCompatActivity {

    private ListView jobListView;
    private ArrayList<String> jobList;
    private ArrayList<Integer> selectedPositions = new ArrayList<>();
    private ArrayList<ScoredJob> scoredJobsForIntent = new ArrayList<>();
    private JobComparator jobComparator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_jobs);

        jobComparator = new JobComparator();
        jobListView = findViewById(R.id.jobListView);
        jobList = new ArrayList<>();
        List<ScoredJob> scoredJobs = new ArrayList<>();
        ComparisonSetting settings = MainActivity.jobApp.getSettings();

        if (MainActivity.jobApp.getCurrentJob() != null) {
            Job currentJob = MainActivity.jobApp.getCurrentJob();
            scoredJobs.add(jobComparator.scoreJob("Current Job", currentJob, settings));
        }

        List<Job> offers = MainActivity.jobApp.getJobOffers();
        for (int i = 0; i < offers.size(); i++) {
            Job job = offers.get(i);
            scoredJobs.add(jobComparator.scoreJob("Offer " + (i + 1), job, settings));
        }

        Collections.sort(scoredJobs, (a, b) -> b.score.compareTo(a.score));

        // For intent serialization
        scoredJobsForIntent.addAll(scoredJobs);

        for (ScoredJob sj : scoredJobs) {
            jobList.add(sj.label + ": " + sj.job.getTitle() + " at " + sj.job.getCompany()
                    + " (" + sj.job.getLocation().getCity() + ", " + sj.job.getLocation().getState() + ") - Score: " + sj.score);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, jobList);
        jobListView.setAdapter(adapter);
        jobListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        jobListView.setOnItemClickListener((parent, view, position, id) -> {
            if (selectedPositions.contains(position)) {
                selectedPositions.remove(Integer.valueOf(position));
            } else {
                selectedPositions.add(position);
            }
        });

        Button compareButton = findViewById(R.id.compareButton);
        compareButton.setOnClickListener(v -> {
            if (selectedPositions.size() != 2) {
                Toast.makeText(CompareJobsActivity.this, "Please select exactly two jobs to compare.", Toast.LENGTH_SHORT).show();
                return;
            }

            int pos1 = selectedPositions.get(0);
            int pos2 = selectedPositions.get(1);

            Intent intent = new Intent(CompareJobsActivity.this, ComparisonResultActivity.class);
            intent.putExtra("job1Index", pos1);
            intent.putExtra("job2Index", pos2);
            intent.putExtra("scoredJobs", scoredJobsForIntent);
            startActivity(intent);
        });
    }
}