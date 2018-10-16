package com.example.corefield.fieldjob.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class EmployeeDBManager {

    private EmployeeDatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public EmployeeDBManager(Context c) {
        context = c;
    }

    public EmployeeDBManager open() throws SQLException {
        dbHelper = new EmployeeDatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(int age, String imageUrl, String name, String dep, String des, String gender,
                       int basicPay, int nonTax, int TaxA, int grossPay, int SSS, int Phill, int PAG,
                       int TDS, int netincome, String Height, int Weight, int BloodRate, String BBM,
                       String BP, String Paracetemol, String Amoxin, String Floxin) {
        ContentValues contentValue = new ContentValues();

        contentValue.put(EmployeeDatabaseHelper.AGE, age);
        contentValue.put(EmployeeDatabaseHelper.IMAGE, imageUrl);
        contentValue.put(EmployeeDatabaseHelper.NAME, name);
        contentValue.put(EmployeeDatabaseHelper.DEP, dep);
        contentValue.put(EmployeeDatabaseHelper.DES, des);
        contentValue.put(EmployeeDatabaseHelper.GENDER, gender);
        contentValue.put(EmployeeDatabaseHelper.BASICPAY, basicPay);
        contentValue.put(EmployeeDatabaseHelper.NONTAX, nonTax);
        contentValue.put(EmployeeDatabaseHelper.TAXA, TaxA);
        contentValue.put(EmployeeDatabaseHelper.GROSSPAY, grossPay);
        contentValue.put(EmployeeDatabaseHelper.SSS, SSS);
        contentValue.put(EmployeeDatabaseHelper.MPHILL, Phill);
        contentValue.put(EmployeeDatabaseHelper.PAG, PAG);
        contentValue.put(EmployeeDatabaseHelper.TDS, TDS);
        contentValue.put(EmployeeDatabaseHelper.NETINCOME, netincome);
        contentValue.put(EmployeeDatabaseHelper.HEIGHT, Height);
        contentValue.put(EmployeeDatabaseHelper.WEIGHT, Weight);
        contentValue.put(EmployeeDatabaseHelper.BLOODRATE, BloodRate);
        contentValue.put(EmployeeDatabaseHelper.BBM, BBM);
        contentValue.put(EmployeeDatabaseHelper.BP, BP);
        contentValue.put(EmployeeDatabaseHelper.PARACETAMOL, Paracetemol);
        contentValue.put(EmployeeDatabaseHelper.AMOXIN, Amoxin);
        contentValue.put(EmployeeDatabaseHelper.FLOXIN, Floxin);
        database.insert(EmployeeDatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[]{
                /*DatabaseHelper._ID,*/
                EmployeeDatabaseHelper.AGE,
                EmployeeDatabaseHelper.IMAGE,
                EmployeeDatabaseHelper.NAME,
                EmployeeDatabaseHelper.DEP,
                EmployeeDatabaseHelper.DES,
                EmployeeDatabaseHelper.GENDER,
                EmployeeDatabaseHelper.BASICPAY,
                EmployeeDatabaseHelper.NONTAX,
                EmployeeDatabaseHelper.TAXA,
                EmployeeDatabaseHelper.GROSSPAY,
                EmployeeDatabaseHelper.SSS,
                EmployeeDatabaseHelper.MPHILL,
                EmployeeDatabaseHelper.PAG,
                EmployeeDatabaseHelper.TDS,
                EmployeeDatabaseHelper.NETINCOME,
                EmployeeDatabaseHelper.HEIGHT,
                EmployeeDatabaseHelper.WEIGHT,
                EmployeeDatabaseHelper.BLOODRATE,
                EmployeeDatabaseHelper.BBM,
                EmployeeDatabaseHelper.PARACETAMOL,
                EmployeeDatabaseHelper.AMOXIN,
                EmployeeDatabaseHelper.FLOXIN};
        Cursor cursor = database.query(EmployeeDatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, int age, String imageUrl, String name, String dep, String des, String gender,
                      int basicPay, int nonTax, int TaxA, int grossPay, int SSS, int Phill, int PAG,
                      int TDS, int netincome, String Height, int Weight, int BloodRate, String BBM,
                      String BP, String Paracetemol, String Amoxin, String Floxin) {

        ContentValues contentValue = new ContentValues();
        contentValue.put(EmployeeDatabaseHelper.AGE, age);
        contentValue.put(EmployeeDatabaseHelper.IMAGE, imageUrl);
        contentValue.put(EmployeeDatabaseHelper.NAME, name);
        contentValue.put(EmployeeDatabaseHelper.DEP, dep);
        contentValue.put(EmployeeDatabaseHelper.DES, des);
        contentValue.put(EmployeeDatabaseHelper.GENDER, gender);
        contentValue.put(EmployeeDatabaseHelper.BASICPAY, basicPay);
        contentValue.put(EmployeeDatabaseHelper.NONTAX, nonTax);
        contentValue.put(EmployeeDatabaseHelper.TAXA, TaxA);
        contentValue.put(EmployeeDatabaseHelper.GROSSPAY, grossPay);
        contentValue.put(EmployeeDatabaseHelper.SSS, SSS);
        contentValue.put(EmployeeDatabaseHelper.MPHILL, Phill);
        contentValue.put(EmployeeDatabaseHelper.PAG, PAG);
        contentValue.put(EmployeeDatabaseHelper.TDS, TDS);
        contentValue.put(EmployeeDatabaseHelper.NETINCOME, netincome);
        contentValue.put(EmployeeDatabaseHelper.HEIGHT, Height);
        contentValue.put(EmployeeDatabaseHelper.WEIGHT, Weight);
        contentValue.put(EmployeeDatabaseHelper.BLOODRATE, BloodRate);
        contentValue.put(EmployeeDatabaseHelper.BBM, BBM);
        contentValue.put(EmployeeDatabaseHelper.PARACETAMOL, Paracetemol);
        contentValue.put(EmployeeDatabaseHelper.AMOXIN, Amoxin);
        contentValue.put(EmployeeDatabaseHelper.FLOXIN, Floxin);

        int i = database.update(EmployeeDatabaseHelper.TABLE_NAME, contentValue, EmployeeDatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(EmployeeDatabaseHelper.TABLE_NAME, EmployeeDatabaseHelper._ID + "=" + _id, null);
    }
}
