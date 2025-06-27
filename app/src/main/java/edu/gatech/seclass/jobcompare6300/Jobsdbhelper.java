package edu.gatech.seclass.jobcompare6300;
// For this SQL part, we referenced the structure from the tutorial
// (https://developer.android.com/training/data-storage/sqlite#java)
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Jobsdbhelper extends SQLiteOpenHelper {
    // Create Job table
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Jobsdb.JobEntry.TABLE_NAME + " (" +
                    Jobsdb.JobEntry._ID + " INTEGER PRIMARY KEY," +
                    Jobsdb.JobEntry.COLUMN_TITLE + " TEXT," +
                    Jobsdb.JobEntry.COLUMN_COMPANY + " TEXT," +
                    Jobsdb.JobEntry.COLUMN_CITY + " TEXT," +
                    Jobsdb.JobEntry.COLUMN_STATE + " TEXT," +
                    Jobsdb.JobEntry.COLUMN_COST_OF_LIVING + " INTEGER," +
                    Jobsdb.JobEntry.COLUMN_SALARY + " REAL," +
                    Jobsdb.JobEntry.COLUMN_BONUS + " REAL," +
                    Jobsdb.JobEntry.COLUMN_WELLNESS + " REAL," +
                    Jobsdb.JobEntry.COLUMN_DENTAL + " REAL," +
                    Jobsdb.JobEntry.COLUMN_RELOCATION + " REAL)";
    // For database schema updates
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "job.db";
    // For table delete
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Jobsdb.JobEntry.TABLE_NAME;
    // Initialize helper
    public Jobsdbhelper(Context context) {
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
