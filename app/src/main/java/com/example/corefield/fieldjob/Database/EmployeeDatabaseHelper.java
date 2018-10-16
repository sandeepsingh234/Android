package com.example.corefield.fieldjob.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeDatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "EMPLOYEE";

    // Table columns
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String IMAGE = "image";
    public static final String DES = "des";
    public static final String DEP = "dep";
    public static final String GENDER = "gender";
    public static final String AGE = "age";
    public static final String BASICPAY = "basicPay";
    public static final String GROSSPAY = "grossPay";
    public static final String SSS = "SSS";
    public static final String MPHILL = "mPhill";
    public static final String PAG = "PAG";
    public static final String NONTAX = "nonTax";
    public static final String TAXA = "TaxA";
    public static final String TDS = "TDS";
    public static final String NETINCOME = "netincome";
    public static final String HEIGHT = "Height";
    public static final String WEIGHT = "Weight";
    public static final String BLOODRATE = "BloodRate";
    public static final String BBM = "BBM";
    public static final String BP = "BP";
    public static final String PARACETAMOL = "Paracetemol";
    public static final String AMOXIN = "Amoxin";
    public static final String FLOXIN = "Floxin";

    // Database Information
    static final String DB_NAME = "EMPLOYEE.DB";

    // database version
    static final int DB_VERSION = 1;
    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +
            "("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + AGE + " INTEGER NOT NULL, "
            + IMAGE + " TEXT NOT NULL, "
            + NAME + " TEXT NOT NULL, "
            + DEP + " TEXT NOT NULL, "
            + DES + " TEXT NOT NULL, "
            + GENDER + " TEXT NOT NULL, "
            + BASICPAY + " INTEGER NOT NULL, "
            + NONTAX + " INTEGER NOT NULL, "
            + TAXA + " INTEGER NOT NULL, "
            + GROSSPAY + " INTEGER NOT NULL, "
            + SSS + " INTEGER NOT NULL, "
            + MPHILL + " INTEGER NOT NULL, "
            + PAG + " INTEGER NOT NULL, "
            + TDS + " INTEGER NOT NULL, "
            + NETINCOME + " INTEGER NOT NULL, "
            + HEIGHT + " TEXT NOT NULL, "
            + WEIGHT + " INTEGER NOT NULL, "
            + BLOODRATE + " INTEGER NOT NULL, "
            + BBM + " TEXT NOT NULL, "
            + BP + " TEXT NOT NULL, "
            + PARACETAMOL + " TEXT NOT NULL, "
            + AMOXIN + " TEXT NOT NULL, "
            + FLOXIN + " TEXT);";


    public EmployeeDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
