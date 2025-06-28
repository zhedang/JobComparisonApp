package edu.gatech.seclass.jobcompare6300;
// For this SQL part, we referenced the structure from the tutorial
// (https://developer.android.com/training/data-storage/sqlite#java)
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Settingsdbhelper extends SQLiteOpenHelper {
    // Create Setting table
    //TODO: Later check if enterjoboffers/entercurrentjob inputs types align with below
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Settingsdb.SettingEntry.TABLE_NAME + " (" +
                    Settingsdb.SettingEntry._ID + " INTEGER PRIMARY KEY," +

                    Settingsdb.SettingEntry.COLUMN_SALARY + " REAL," +
                    Settingsdb.SettingEntry.COLUMN_BONUS + " REAL," +
                    Settingsdb.SettingEntry.COLUMN_RELOCATION + " REAL," +
                    Settingsdb.SettingEntry.COLUMN_WELLNESS + " REAL," +
                    Settingsdb.SettingEntry.COLUMN_DENTAL + " REAL)";
    // For database schema updates
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "setting.db";
    // For table delete
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Settingsdb.SettingEntry.TABLE_NAME;
    // Initialize helper
    public Settingsdbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Simple strategy: drop and recreate
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}