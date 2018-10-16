package com.example.corefield.fieldjob.DTO;

import android.os.Parcel;
import android.os.Parcelable;

public class EmployeeHealth implements Parcelable {


    public static final Creator<EmployeeHealth> CREATOR = new Creator<EmployeeHealth>() {
        @Override
        public EmployeeHealth createFromParcel(Parcel in) {
            return new EmployeeHealth(in);
        }

        @Override
        public EmployeeHealth[] newArray(int size) {
            return new EmployeeHealth[size];
        }
    };
    //////////////////////////////////////////
    private String mHeight;
    private int mWeight, mBloodRate;
    private String mBBM, mBP, mDesignation, mGender, mParacetemol, mAmoxin, mFloxin;
    private boolean mSugar, mCancer, mMalaria, mNightBlindness;
    ///////////////////////////////////////////

    public EmployeeHealth(String mHeight, int mWeight, int mBloodRate, String mBBM, String mBP, String mDesignation, String mGender,
                          String mParacetemol, String mAmoxin, String mFloxin, boolean mSugar, boolean mCancer, boolean mMalaria,
                          boolean mNightBlindness) {

        this.mHeight = mHeight;
        this.mWeight = mWeight;
        this.mBloodRate = mBloodRate;
        this.mBBM = mBBM;
        this.mBP = mBP;
        this.mDesignation = mDesignation;
        this.mGender = mGender;
        this.mParacetemol = mParacetemol;
        this.mAmoxin = mAmoxin;
        this.mFloxin = mFloxin;
        this.mSugar = mSugar;
        this.mCancer = mCancer;
        this.mMalaria = mMalaria;
        this.mNightBlindness = mNightBlindness;
    }

    public EmployeeHealth() {
    }

    public String getmHeight() {
        return mHeight;
    }

    public void setmHeight(String mHeight) {
        this.mHeight = mHeight;
    }

    public int getmWeight() {
        return mWeight;
    }

    public void setmWeight(int mWeight) {
        this.mWeight = mWeight;
    }

    public int getmBloodRate() {
        return mBloodRate;
    }

    public void setmBloodRate(int mBloodRate) {
        this.mBloodRate = mBloodRate;
    }

    public String getmBBM() {
        return mBBM;
    }

    public void setmBBM(String mBBM) {
        this.mBBM = mBBM;
    }

    public String getmBP() {
        return mBP;
    }

    public void setmBP(String mBP) {
        this.mBP = mBP;
    }

    public String getmDesignation() {
        return mDesignation;
    }

    public void setmDesignation(String mDesignation) {
        this.mDesignation = mDesignation;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public String getmParacetemol() {
        return mParacetemol;
    }

    public void setmParacetemol(String mParacetemol) {
        this.mParacetemol = mParacetemol;
    }

    public String getmAmoxin() {
        return mAmoxin;
    }

    public void setmAmoxin(String mAmoxin) {
        this.mAmoxin = mAmoxin;
    }

    public String getmFloxin() {
        return mFloxin;
    }

    public void setmFloxin(String mFloxin) {
        this.mFloxin = mFloxin;
    }

    public boolean ismSugar() {
        return mSugar;
    }

    public void setmSugar(boolean mSugar) {
        this.mSugar = mSugar;
    }

    public boolean ismCancer() {
        return mCancer;
    }

    public void setmCancer(boolean mCancer) {
        this.mCancer = mCancer;
    }

    public boolean ismMalaria() {
        return mMalaria;
    }

    public void setmMalaria(boolean mMalaria) {
        this.mMalaria = mMalaria;
    }

    public boolean ismNightBlindness() {
        return mNightBlindness;
    }

    public void setmNightBlindness(boolean mNightBlindness) {
        this.mNightBlindness = mNightBlindness;
    }

    protected EmployeeHealth(Parcel in) {
        mHeight = in.readString();
        mWeight = in.readInt();
        mBloodRate = in.readInt();
        mBBM = in.readString();
        mBP = in.readString();
        mDesignation = in.readString();
        mGender = in.readString();
        mParacetemol = in.readString();
        mAmoxin = in.readString();
        mFloxin = in.readString();
        mSugar = in.readByte() != 0;
        mCancer = in.readByte() != 0;
        mMalaria = in.readByte() != 0;
        mNightBlindness = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mHeight);
        parcel.writeInt(mWeight);
        parcel.writeInt(mBloodRate);
        parcel.writeString(mBBM);
        parcel.writeString(mBP);
        parcel.writeString(mDesignation);
        parcel.writeString(mGender);
        parcel.writeString(mParacetemol);
        parcel.writeString(mAmoxin);
        parcel.writeString(mFloxin);
        parcel.writeByte((byte) (mSugar ? 1 : 0));
        parcel.writeByte((byte) (mCancer ? 1 : 0));
        parcel.writeByte((byte) (mMalaria ? 1 : 0));
        parcel.writeByte((byte) (mNightBlindness ? 1 : 0));
    }

    @Override
    public String toString() {
        return "EmployeeHealth{" +
                "mHeight=" + mHeight +
                ", mWeight=" + mWeight +
                ", mBloodRate=" + mBloodRate +
                ", mBBM='" + mBBM + '\'' +
                ", mBP='" + mBP + '\'' +
                ", mDesignation='" + mDesignation + '\'' +
                ", mGender='" + mGender + '\'' +
                ", mParacetemol='" + mParacetemol + '\'' +
                ", mAmoxin='" + mAmoxin + '\'' +
                ", mFloxin='" + mFloxin + '\'' +
                ", mSugar=" + mSugar +
                ", mCancer=" + mCancer +
                ", mMalaria=" + mMalaria +
                ", mNightBlindness=" + mNightBlindness +
                '}';
    }
}
