package it.flaviodepedis.mymedicinetracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import it.flaviodepedis.mymedicinetracker.data.MedicineContract.*;

/**
 * Created by flavio.depedis on 26/09/2017.
 */

public class MedicineDbHelper extends SQLiteOpenHelper {


    public static final String LOG_TAG = MedicineDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "medicine.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public MedicineDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the medicines table
        String SQL_CREATE_MEDICINES_TABLE =  "CREATE TABLE " + MedicineEntry.TABLE_NAME + " ("
                + MedicineEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MedicineEntry.COLUMN_MED_NAME + " TEXT NOT NULL, "
                + MedicineEntry.COLUMN_MED_TYPE + " TEXT, "
                + MedicineEntry.COLUMN_MED_QUANTITY + " INTEGER NOT NULL, "
                + MedicineEntry.COLUMN_MED_EXPIRY_DATE + " TEXT,"
                + MedicineEntry.COLUMN_MED_NOTE + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_MEDICINES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

