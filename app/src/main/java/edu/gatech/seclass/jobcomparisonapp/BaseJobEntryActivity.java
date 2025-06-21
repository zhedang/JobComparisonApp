package edu.gatech.seclass.jobcomparisonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.math.BigDecimal;

public abstract class BaseJobEntryActivity extends AppCompatActivity {

    protected EditText etTitle, etCompany, etCity, etState, etCostOfLiving;
    protected EditText etYearlySalary, etYearlyBonus, etWellnessFund, etDentalInsurance, etRelocationAllowance;
    protected Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        initializeViews();
        setupListeners();
    }

    protected abstract int getLayoutResourceId();
    protected abstract String getSuccessMessage();
    protected abstract void saveJob(Job job);

    private void initializeViews() {
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
    }

    private void setupListeners() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Job newJob = createJobFromInput();
                    saveJob(newJob);
                    Toast.makeText(BaseJobEntryActivity.this, getSuccessMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(BaseJobEntryActivity.this, "Error: Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseJobEntryActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private Job createJobFromInput() {
        String title = etTitle.getText().toString();
        String company = etCompany.getText().toString();
        String city = etCity.getText().toString();
        String state = etState.getText().toString();
        int costOfLiving = Integer.parseInt(etCostOfLiving.getText().toString());

        BigDecimal yearlySalary = new BigDecimal(etYearlySalary.getText().toString());
        BigDecimal yearlyBonus = new BigDecimal(etYearlyBonus.getText().toString());
        BigDecimal wellnessFund = new BigDecimal(etWellnessFund.getText().toString());
        BigDecimal dentalInsurance = new BigDecimal(etDentalInsurance.getText().toString());
        BigDecimal relocationAllowance = new BigDecimal(etRelocationAllowance.getText().toString());

        Location location = new Location(city, state, costOfLiving);
        return new Job(title, company, location, yearlySalary, yearlyBonus, wellnessFund, dentalInsurance, relocationAllowance);
    }
} 