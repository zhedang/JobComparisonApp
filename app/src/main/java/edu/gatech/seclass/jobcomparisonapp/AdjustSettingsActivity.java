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

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdjustSettingsActivity.this, "Settings Saved", Toast.LENGTH_SHORT).show();
                finish();
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
}