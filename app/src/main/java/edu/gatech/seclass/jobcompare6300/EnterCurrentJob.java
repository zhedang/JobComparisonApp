package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;

// Setting up EnterCurrentJob navigation
public class EnterCurrentJob extends AppCompatActivity{
    private Jobsdbhelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_current_job);
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
            values.put("title", title.getText().toString());
            values.put("company", company.getText().toString());
            values.put("city", city.getText().toString());
            values.put("state", state.getText().toString());
            values.put("cost_of_living", Integer.parseInt(cost.getText().toString()));
            values.put("salary", Double.parseDouble(salary.getText().toString()));
            values.put("bonus", Double.parseDouble(bonus.getText().toString()));
            values.put("wellness", Double.parseDouble(wellness.getText().toString()));
            values.put("dental", Double.parseDouble(dental.getText().toString()));
            values.put("relocation", Double.parseDouble(relocation.getText().toString()));
            db.insert("job", null, values);
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
