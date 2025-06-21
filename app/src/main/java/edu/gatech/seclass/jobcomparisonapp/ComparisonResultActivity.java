// File: ComparisonResultActivity.java
package edu.gatech.seclass.jobcomparisonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ComparisonResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_result);

        int job1Index = getIntent().getIntExtra("job1Index", -1);
        int job2Index = getIntent().getIntExtra("job2Index", -1);
        ArrayList<ScoredJob> scoredJobs = (ArrayList<ScoredJob>) getIntent().getSerializableExtra("scoredJobs");

        ScoredJob job1 = scoredJobs.get(job1Index);
        ScoredJob job2 = scoredJobs.get(job2Index);

        String comparison = buildComparisonText(job1, job2);

        TextView comparisonTextView = findViewById(R.id.comparisonTextView);
        comparisonTextView.setText(comparison);

        Button btnCompareAgain = findViewById(R.id.btnCompareAgain);
        Button btnReturnHome = findViewById(R.id.btnReturnHome);

        btnCompareAgain.setOnClickListener(v -> finish());

        btnReturnHome.setOnClickListener(v -> {
            Intent intent = new Intent(ComparisonResultActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }

    private String buildComparisonText(ScoredJob job1, ScoredJob job2) {
        Job j1 = job1.job;
        Job j2 = job2.job;

        return "Comparison Result:\n" +
                "Title: " + j1.getTitle() + " vs. " + j2.getTitle() + "\n" +
                "Company: " + j1.getCompany() + " vs. " + j2.getCompany() + "\n" +
                "Location: " + j1.getLocation().getCity() + ", " + j1.getLocation().getState() + " vs. " +
                j2.getLocation().getCity() + ", " + j2.getLocation().getState() + "\n" +
                "Yearly Salary (Adj): " + job1.adjustedYearlySalary + " vs. " + job2.adjustedYearlySalary + "\n" +
                "Yearly Bonus (Adj): " + job1.adjustedYearlyBonus + " vs. " + job2.adjustedYearlyBonus + "\n" +
                "Relocation Allowance (Eff): " + job1.effectiveRelocationAllowance + " vs. " + job2.effectiveRelocationAllowance + "\n" +
                "Wellness Stipend (Eff): " + job1.effectiveWellnessStipend + " vs. " + job2.effectiveWellnessStipend + "\n" +
                "Dental Insurance: " + j1.getDentalInsurance() + " vs. " + j2.getDentalInsurance() + "\n" +
                "\nScores: " + job1.score + " vs. " + job2.score;
    }
}
