package com.example.corefield.fieldjob;


public class Employee {

    private int mAge, mImage;
    private String mName, mDepartment, mDesignation, mGender;


    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDepartment() {
        return mDepartment;
    }

    public void setmDepartment(String mDepartment) {
        this.mDepartment = mDepartment;
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

    public Employee(int age, int image, String name, String department, String designation, String gender) {
        this.mAge = age;
        this.mImage = image;
        this.mName = name;
        this.mDepartment = department;
        this.mDesignation = designation;
        this.mGender = gender;
    }

}
