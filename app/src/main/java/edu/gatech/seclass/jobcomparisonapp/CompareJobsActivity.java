// File: CompareJobsActivity.java
package edu.gatech.seclass.jobcomparisonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class CompareJobsActivity extends AppCompatActivity {

    private ListView jobListView;
    private ArrayList<String> jobList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_jobs);

        jobListView = findViewById(R.id.jobListView);
        jobList = new ArrayList<>();

        // Dummy data for now, will connect with model later
        jobList.add("Current Job: Software Engineer at Google");
        jobList.add("Offer 1: Senior Developer at Amazon");
        jobList.add("Offer 2: Software Engineer II at Microsoft");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jobList);
        jobListView.setAdapter(adapter);

        jobListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedJob = jobList.get(position);
            Toast.makeText(CompareJobsActivity.this, "Selected: " + selectedJob, Toast.LENGTH_SHORT).show();
            // TODO: Future step - open comparison view for selected jobs
        });
    }
}