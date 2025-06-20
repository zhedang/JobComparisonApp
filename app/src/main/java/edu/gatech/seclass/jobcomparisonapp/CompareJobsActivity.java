// File: CompareJobsActivity.java
package edu.gatech.seclass.jobcomparisonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class CompareJobsActivity extends AppCompatActivity {

    private ListView jobListView;
    private ArrayList<String> jobList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_jobs);

        jobListView = findViewById(R.id.jobListView);
        jobList = new ArrayList<>();

        // Load data from the model
        if (MainActivity.jobApp.getCurrentJob() != null) {
            Job currentJob = MainActivity.jobApp.getCurrentJob();
            jobList.add("Current Job: " + currentJob.getTitle() + " at " + currentJob.getCompany()
                    + " (" + currentJob.getLocation().getCity() + ", " + currentJob.getLocation().getState() + ")");
        }

        List<Job> offers = MainActivity.jobApp.getJobOffers();
        for (int i = 0; i < offers.size(); i++) {
            Job job = offers.get(i);
            jobList.add("Offer " + (i + 1) + ": " + job.getTitle() + " at " + job.getCompany()
                    + " (" + job.getLocation().getCity() + ", " + job.getLocation().getState() + ")");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jobList);
        jobListView.setAdapter(adapter);

        jobListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedJob = jobList.get(position);
            Toast.makeText(CompareJobsActivity.this, "Selected: " + selectedJob, Toast.LENGTH_SHORT).show();
            // TODO: Future step - open comparison view for selected jobs
        });
    }
}
