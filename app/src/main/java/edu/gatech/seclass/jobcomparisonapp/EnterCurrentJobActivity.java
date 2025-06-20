package edu.gatech.seclass.jobcomparisonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterCurrentJobActivity extends AppCompatActivity {

    private EditText etTitle, etCompany, etCity, etState, etCostOfLiving;
    private EditText etYearlySalary, etYearlyBonus, etWellnessFund, etDentalInsurance, etRelocationAllowance;
    private Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_current_job);

        etTitle = findViewById(R.id.etTitle);
        etCompany = findViewById(R.id.etCompany);
        etCity = findViewById(R.id.etCity);
        etState = findViewById(R.id.etState);
        etCostOfLiving = findViewById(R.id.etCostOfLiving);
        etYearlySalary = findViewById(R.id.etYearlySalary);
        etYearlyBonus = findViewById(R.id.etYearlyBonus);
        etWellnessFund = findViewById(R.id.etWellnessFund);
        etDentalInsurance = findViewById(R.id.etDentalInsurance);
        etRelocationAllowance = findViewById(R.id.etRelocationAllowance);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EnterCurrentJobActivity.this, "Current Job Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EnterCurrentJobActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}