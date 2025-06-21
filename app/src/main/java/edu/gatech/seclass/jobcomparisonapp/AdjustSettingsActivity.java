// File: AdjustSettingsActivity.java
package edu.gatech.seclass.jobcomparisonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdjustSettingsActivity extends AppCompatActivity {

    private EditText etSalaryWeight, etBonusWeight, etRelocationWeight, etWellnessWeight, etDentalWeight;
    private Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_settings);

        etSalaryWeight = findViewById(R.id.etSalaryWeight);
        etBonusWeight = findViewById(R.id.etBonusWeight);
        etRelocationWeight = findViewById(R.id.etRelocationWeight);
        etWellnessWeight = findViewById(R.id.etWellnessWeight);
        etDentalWeight = findViewById(R.id.etDentalWeight);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        // Load current settings
        loadCurrentSettings();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int salaryWeight = Integer.parseInt(etSalaryWeight.getText().toString());
                    int bonusWeight = Integer.parseInt(etBonusWeight.getText().toString());
                    int relocationWeight = Integer.parseInt(etRelocationWeight.getText().toString());
                    int wellnessWeight = Integer.parseInt(etWellnessWeight.getText().toString());
                    int dentalWeight = Integer.parseInt(etDentalWeight.getText().toString());

                    ComparisonSetting newSettings = new ComparisonSetting(
                            salaryWeight, bonusWeight, relocationWeight, wellnessWeight, dentalWeight);
                    
                    MainActivity.jobApp.adjustSettings(newSettings);
                    Toast.makeText(AdjustSettingsActivity.this, "Settings Saved", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(AdjustSettingsActivity.this, "Error: Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdjustSettingsActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void loadCurrentSettings() {
        ComparisonSetting currentSettings = MainActivity.jobApp.getSettings();
        etSalaryWeight.setText(String.valueOf(currentSettings.getYearlySalaryWeight()));
        etBonusWeight.setText(String.valueOf(currentSettings.getYearlyBonusWeight()));
        etRelocationWeight.setText(String.valueOf(currentSettings.getRelocationAllowanceWeight()));
        etWellnessWeight.setText(String.valueOf(currentSettings.getWellnessFundWeight()));
        etDentalWeight.setText(String.valueOf(currentSettings.getDentalInsuranceWeight()));
    }
}