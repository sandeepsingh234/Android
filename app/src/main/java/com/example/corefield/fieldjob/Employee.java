package com.example.corefield.fieldjob;

public class Employee {

    int mAGE,mIMAGE;
    String mNAME, mDEPARTMENT ,mDESIGNATION;

    public Employee(int AGE, int IMAGE, String NAME, String DEPARTMENT, String DESIGNATION) {
        this.mAGE = AGE;
        this.mIMAGE = IMAGE;
        this.mNAME = NAME;
        this.mDEPARTMENT = DEPARTMENT;
        this.mDESIGNATION = DESIGNATION;
    }

    public int getAGE() {
        return mAGE;
    }

    public int getIMAGE() {
        return mIMAGE;
    }

    public String getNAME() {
        return mNAME;
    }

    public String getDEPARTMENT() {
        return mDEPARTMENT;
    }

    public String getDESIGNATION() {
        return mDESIGNATION;
    }
}
