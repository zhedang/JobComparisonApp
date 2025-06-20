package edu.gatech.seclass.jobcomparisonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static JobComparisonApp jobApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jobApp = new JobComparisonApp();

        Button btnEnterCurrentJob = findViewById(R.id.btnEnterCurrentJob);
        Button btnEnterJobOffer = findViewById(R.id.btnEnterJobOffer);
        Button btnAdjustSettings = findViewById(R.id.btnAdjustSettings);
        Button btnCompareJobs = findViewById(R.id.btnCompareJobs);

        btnEnterCurrentJob.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EnterCurrentJobActivity.class);
            startActivity(intent);
        });

        btnEnterJobOffer.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EnterJobOfferActivity.class);
            startActivity(intent);
        });

        btnAdjustSettings.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AdjustSettingsActivity.class);
            startActivity(intent);
        });

        btnCompareJobs.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CompareJobsActivity.class);
            startActivity(intent);
        });
    }
}
