package com.example.corefield.fieldjob.DTO;


import android.os.Parcel;
import android.os.Parcelable;


public class Employee implements Parcelable {

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    ///////////////////////////////////////////////////////
    private int mAge;
    private String mName, mDepartment, mDesignation, mGender, mImage;
    public EmployeeSalary employeeSalary = new EmployeeSalary();
    public EmployeeHealth employeeHealth = new EmployeeHealth();

    ////////////////////////////////////////////////////////////
    public Employee(int age, String image, String name, String department, String designation, String gender, EmployeeSalary employeeSalary, EmployeeHealth employeeHealth) {
        this.mAge = age;
        this.mImage = image;
        this.mName = name;
        this.mDepartment = department;
        this.mDesignation = designation;
        this.mGender = gender;
        this.employeeSalary = employeeSalary;
        this.employeeHealth = employeeHealth;
    }

    protected Employee(Parcel in) {
        mAge = in.readInt();
        mImage = in.readString();
        mName = in.readString();
        mDepartment = in.readString();
        mDesignation = in.readString();
        mGender = in.readString();
        this.employeeSalary = in.readParcelable(EmployeeSalary.class.getClassLoader());
        this.employeeHealth = in.readParcelable(EmployeeHealth.class.getClassLoader());

    }


    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mAge);
        parcel.writeString(mImage);
        parcel.writeString(mName);
        parcel.writeString(mDepartment);
        parcel.writeString(mDesignation);
        parcel.writeString(mGender);
        parcel.writeParcelable(employeeSalary, i);
        parcel.writeParcelable(employeeHealth, i);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "mAge=" + mAge +
                ", mImage=" + mImage +
                ", mName='" + mName + '\'' +
                ", mDepartment='" + mDepartment + '\'' +
                ", mDesignation='" + mDesignation + '\'' +
                ", mGender='" + mGender + '\'' +
                ", salary='" + employeeSalary + '\'' +
                ", health='" + employeeHealth + '\'' +
                '}';
    }
}
