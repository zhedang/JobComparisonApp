package edu.gatech.seclass.jobcompare6300;

// For this SQL part, we referenced the structure from the tutorial
// (https://developer.android.com/training/data-storage/sqlite#java)
import android.provider.BaseColumns;

public final class Settingsdb {

    // Private constructor so nobody accidentally instantiates this class
    // make the constructor private.
    private Settingsdb() {}

    // Inner class that defines the table contents
    public static class SettingEntry implements BaseColumns {
        public static final String TABLE_NAME = "setting";
        public static final String COLUMN_SALARY = "salary";
        public static final String COLUMN_BONUS = "bonus";
        public static final String COLUMN_RELOCATION = "relocation";
        public static final String COLUMN_WELLNESS = "wellness";
        public static final String COLUMN_DENTAL = "dental";

    }
}