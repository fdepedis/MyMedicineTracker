package it.flaviodepedis.mymedicinetracker.data;

import android.provider.BaseColumns;

/**
 * Created by flavio.depedis on 26/09/2017.
 */

public class MedicineContract {

    /**
     * Empty constructor
     */
    public MedicineContract() {
    }

    public static final class MedicineEntry implements BaseColumns {


        /** Name of database table for medicines */
        public static final String TABLE_NAME = "medicines";

        /** Name of columns table for medicines */
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_MED_NAME ="med_name";                     // Type: TEXT
        public static final String COLUMN_MED_TYPE = "med_type";                    // Type: TEXT
        public static final String COLUMN_MED_QUANTITY = "med_qty";                 // Type: INTEGER
        public static final String COLUMN_MED_EXP_DATE = "med_expiry_date";         // Type: TEXT
        public static final String COLUMN_MED_NOTE = "med_note";                    // Type: TEXT

        /** Name of constants for medicines */
        public static final String TYPE_LIQUID = "liquid";
        public static final String TYPE_SUPPOSITORY = "suppository";
        public static final String TYPE_PASTILLE = "pastille";

        /**
         * Returns whether or not the given type medicine value is valid
         */
        public static boolean isValidMedicineType(String type) {
            if (type.equals(TYPE_LIQUID) || type.equals(TYPE_SUPPOSITORY) || type.equals(TYPE_PASTILLE) ) {
                return true;
            }
            return false;
        }

    }
}
