package it.flaviodepedis.mymedicinetracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import it.flaviodepedis.mymedicinetracker.data.MedicineContract.*;
import it.flaviodepedis.mymedicinetracker.data.MedicineDBHelper;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Define an instance of DBHelper class */
        MedicineDBHelper mDbHelper = new MedicineDBHelper(this);

        /** Insert dummy records to test - 1 */
        mDbHelper.insertMedicine(
                "Tachipirina",
                MedicineEntry.TYPE_SUPPOSITORY,
                20,
                "2019/08/01",
                "Fever"
        );

        /** Insert dummy records to test - 2 */
        mDbHelper.insertMedicine(
                "Brufen Child",
                MedicineEntry.TYPE_LIQUID,
                0,
                "2019/08/01",
                "Influence");

        /** Insert dummy records to test - 3 */
        mDbHelper.insertMedicine(
                "Momentdol",
                MedicineEntry.TYPE_PASTILLE,
                30,
                "2020/01/01",
                "Headache");


        /** Read the table through a cursor */
        Cursor medicineCursor = mDbHelper.queryMedicine();

        try {
            while (medicineCursor.moveToNext()) {
                Log.i(LOG_TAG,
                        "Med Name: " + medicineCursor.getString(0) + "\n"
                        + "Med Type: " + medicineCursor.getString(1) + "\n"
                        + "Med Quantity: " + medicineCursor.getInt(2) + "\n"
                        + "Med Expiry Date: " + medicineCursor.getString(3) + "\n"
                        + "Med Note: " + medicineCursor.getString(4) + "\n" );
            }
        } finally {
            medicineCursor.close();
        }

    }
}
