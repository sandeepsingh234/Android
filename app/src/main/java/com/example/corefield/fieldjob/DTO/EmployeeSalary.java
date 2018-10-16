package com.example.corefield.fieldjob.DTO;

import android.os.Parcel;
import android.os.Parcelable;

public class EmployeeSalary implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public EmployeeSalary createFromParcel(Parcel in) {
            return new EmployeeSalary(in);
        }

        public EmployeeSalary[] newArray(int size) {
            return new EmployeeSalary[size];
        }
    };
    ////////////////////////////////
    private int mBasicPay, mNon_Tax, mTax_A, mGrossPay, mSSS, mPhill, mPAG, mTDS, mNetincome;


    /////////////////////////////////
    public EmployeeSalary(int mBasicPay, int mNon_Tax, int mTax_A, int mGrossPay, int mSSS, int mPhill, int mPAG, int mTDS, int mNetincome) {
        this.mBasicPay = mBasicPay;
        this.mNon_Tax = mNon_Tax;
        this.mTax_A = mTax_A;
        this.mGrossPay = mGrossPay;
        this.mSSS = mSSS;
        this.mPhill = mPhill;
        this.mPAG = mPAG;
        this.mTDS = mTDS;
        this.mNetincome = mNetincome;
    }

    public EmployeeSalary(){}


    public int getmBasicPay() {
        return mBasicPay;
    }

    public void setmBasicPay(int mBasicPay) {
        this.mBasicPay = mBasicPay;
    }

    public int getmNon_Tax() {
        return mNon_Tax;
    }

    public void setmNon_Tax(int mNon_Tax) {
        this.mNon_Tax = mNon_Tax;
    }

    public int getmTax_A() {
        return mTax_A;
    }

    public void setmTax_A(int mTax_A) {
        this.mTax_A = mTax_A;
    }

    public int getmGrossPay() {
        return mGrossPay;
    }

    public void setmGrossPay(int mGrossPay) {
        this.mGrossPay = mGrossPay;
    }

    public int getmSSS() {
        return mSSS;
    }

    public void setmSSS(int mSSS) {
        this.mSSS = mSSS;
    }

    public int getmPhill() {
        return mPhill;
    }

    public void setmPhill(int mPhill) {
        this.mPhill = mPhill;
    }

    public int getmPAG() {
        return mPAG;
    }

    public void setmPAG(int mPAG) {
        this.mPAG = mPAG;
    }

    public int getmTDS() {
        return mTDS;
    }

    public void setmTDS(int mTDS) {
        this.mTDS = mTDS;
    }

    public int getmNetincome() {
        return mNetincome;
    }

    public void setmNet_Income(int mNet_Income) {
        this.mNetincome = mNet_Income;
    }

    public EmployeeSalary(Parcel in) {
        this.mBasicPay = mBasicPay;
        this.mNon_Tax = mNon_Tax;
        this.mTax_A = mTax_A;
        this.mGrossPay = mGrossPay;
        this.mSSS = mSSS;
        this.mPhill = mPhill;
        this.mPAG = mPAG;
        this.mTDS = mTDS;
        this.mNetincome = mNetincome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mBasicPay);
        dest.writeInt(this.mNon_Tax);
        dest.writeInt(this.mTax_A);
        dest.writeInt(this.mGrossPay);
        dest.writeInt(this.mSSS);
        dest.writeInt(this.mPhill);
        dest.writeInt(this.mPAG);
        dest.writeInt(this.mTDS);
        dest.writeInt(this.mNetincome);

    }


    @Override
    public String toString() {
        return "EmployeeSalary{" +
                "mBasicPay=" + mBasicPay +
                ", mNon_Tax=" + mNon_Tax +
                ", mTax_A=" + mTax_A +
                ", mGrossPay=" + mGrossPay +
                ", mSSS=" + mSSS +
                ", mPhill=" + mPhill +
                ", mPAG=" + mPAG +
                ", mTDS=" + mTDS +
                ", mNet_Income=" + mNetincome +
                '}';
    }
}
