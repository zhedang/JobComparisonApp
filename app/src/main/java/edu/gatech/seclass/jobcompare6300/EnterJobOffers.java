package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

// Setting up EnterCurrentJob navigation
public class EnterJobOffers extends AppCompatActivity{
    private Jobsdbhelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_job_offers);
        dbHelper = new Jobsdbhelper(this);
    }
    public void handleClick(View view) {
        if (view.getId() == R.id.save) {
            // Take all user inputs
            EditText title = findViewById(R.id.title);
            EditText company = findViewById(R.id.company);
            EditText city = findViewById(R.id.city);
            EditText state = findViewById(R.id.state);
            EditText cost = findViewById(R.id.costOfLiving);
            EditText salary = findViewById(R.id.yearlySalary);
            EditText bonus = findViewById(R.id.yearlyBonus);
            EditText wellness = findViewById(R.id.wellnessFund);
            EditText dental = findViewById(R.id.dentalInsurance);
            EditText relocation = findViewById(R.id.relocationAllowance);

            // insert into database
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            //TODO:Initial build, all inputs are text. Later consider restrict input type
            values.put(Jobsdb.JobEntry.COLUMN_TITLE, title.getText().toString());
            values.put(Jobsdb.JobEntry.COLUMN_COMPANY, company.getText().toString());
            values.put(Jobsdb.JobEntry.COLUMN_CITY, city.getText().toString());
            values.put(Jobsdb.JobEntry.COLUMN_STATE, state.getText().toString());
            values.put(Jobsdb.JobEntry.COLUMN_COST_OF_LIVING, Integer.parseInt(cost.getText().toString()));
            values.put(Jobsdb.JobEntry.COLUMN_SALARY, Double.parseDouble(salary.getText().toString()));
            values.put(Jobsdb.JobEntry.COLUMN_BONUS, Double.parseDouble(bonus.getText().toString()));
            values.put(Jobsdb.JobEntry.COLUMN_RELOCATION, Double.parseDouble(relocation.getText().toString()));
            values.put(Jobsdb.JobEntry.COLUMN_WELLNESS, Double.parseDouble(wellness.getText().toString()));
            values.put(Jobsdb.JobEntry.COLUMN_DENTAL, Double.parseDouble(dental.getText().toString()));

            db.insert(Jobsdb.JobEntry.TABLE_NAME, null, values);
            db.close();

            // save and go back to main screen
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else if (view.getId() == R.id.cancel) {
            // cancel and go back to main screen
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
