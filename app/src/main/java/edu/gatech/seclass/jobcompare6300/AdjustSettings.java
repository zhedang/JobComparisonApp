package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AdjustSettings extends AppCompatActivity {
    private Settingsdbhelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_settings);
        dbHelper = new Settingsdbhelper(this);
    }
    public void handleClick(View view) {
        if (view.getId() == R.id.save) {
            // Take all user inputs

            EditText salary = findViewById(R.id.yearlySalary);
            EditText bonus = findViewById(R.id.yearlyBonus);
            EditText wellness = findViewById(R.id.wellnessFund);
            EditText dental = findViewById(R.id.dentalInsurance);
            EditText relocation = findViewById(R.id.relocationAllowance);

            // insert into database
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            //TODO:Initial build, all inputs are text. Later consider restrict input type

            values.put(Settingsdb.SettingEntry.COLUMN_SALARY, Double.parseDouble(salary.getText().toString()));
            values.put(Settingsdb.SettingEntry.COLUMN_BONUS, Double.parseDouble(bonus.getText().toString()));
            values.put(Settingsdb.SettingEntry.COLUMN_RELOCATION, Double.parseDouble(relocation.getText().toString()));
            values.put(Settingsdb.SettingEntry.COLUMN_WELLNESS, Double.parseDouble(wellness.getText().toString()));
            values.put(Settingsdb.SettingEntry.COLUMN_DENTAL, Double.parseDouble(dental.getText().toString()));

            db.insert(Settingsdb.SettingEntry.TABLE_NAME, null, values);
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