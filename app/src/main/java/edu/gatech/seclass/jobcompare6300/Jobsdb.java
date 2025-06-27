package edu.gatech.seclass.jobcompare6300;

// For this SQL part, we referenced the structure from the tutorial
// (https://developer.android.com/training/data-storage/sqlite#java)
import android.provider.BaseColumns;

public final class Jobsdb {

    // Private constructor so nobody accidentally instantiates this class
    // make the constructor private.
    private Jobsdb() {}

    // Inner class that defines the table contents
    public static class JobEntry implements BaseColumns {
        public static final String TABLE_NAME = "job";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_COMPANY = "company";
        public static final String COLUMN_CITY = "city";
        public static final String COLUMN_STATE = "state";
        public static final String COLUMN_COST_OF_LIVING = "cost_of_living";
        public static final String COLUMN_SALARY = "salary";
        public static final String COLUMN_BONUS = "bonus";
        public static final String COLUMN_WELLNESS = "wellness";
        public static final String COLUMN_DENTAL = "dental";
        public static final String COLUMN_RELOCATION = "relocation";
    }
}
