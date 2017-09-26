package it.flaviodepedis.mymedicinetracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import it.flaviodepedis.mymedicinetracker.data.MedicineContract.*;

/**
 * Created by flavio.depedis on 26/09/2017.
 */

public class MedicineDBHelper extends SQLiteOpenHelper {


    public static final String LOG_TAG = MedicineDBHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "medicine.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public MedicineDBHelper(Context context) {
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
                + MedicineEntry.COLUMN_MED_EXP_DATE + " TEXT,"
                + MedicineEntry.COLUMN_MED_NOTE + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_MEDICINES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * This method inserts records in the Medicine table
     *
     */
    public void insertMedicine(String name, String type, String quantity, String exp_date, String note) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and parameters of method are the values.
        ContentValues medicineValues = new ContentValues();
        medicineValues.put(MedicineEntry.COLUMN_MED_NAME, name);
        medicineValues.put(MedicineEntry.COLUMN_MED_TYPE, type);
        medicineValues.put(MedicineEntry.COLUMN_MED_QUANTITY, quantity);
        medicineValues.put(MedicineEntry.COLUMN_MED_EXP_DATE, exp_date);
        medicineValues.put(MedicineEntry.COLUMN_MED_NOTE, note);

        sqLiteDatabase.insert(MedicineEntry.TABLE_NAME, null, medicineValues);
    }

    /**
     * This method select the records in the Medicine table
     *
     */
    public Cursor queryMedicine() {

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                MedicineEntry._ID,
                MedicineEntry.COLUMN_MED_NAME,
                MedicineEntry.COLUMN_MED_TYPE,
                MedicineEntry.COLUMN_MED_QUANTITY,
                MedicineEntry.COLUMN_MED_EXP_DATE,
                MedicineEntry.COLUMN_MED_NOTE
        };

        return sqLiteDatabase.query(
                MedicineEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }
}

