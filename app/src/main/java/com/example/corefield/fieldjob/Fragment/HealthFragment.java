package com.example.corefield.fieldjob.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.corefield.fieldjob.DTO.Employee;
import com.example.corefield.fieldjob.R;

public class HealthFragment extends Fragment

{
    private View mRootView;
    private TextView mHeight, mWeight, mBloodRate, mParacetemol, mAmoxin, mFloxin, mBBM, mBloodPressure;
    private CheckBox mSugar, mCancer, mMalaria, mNightBlindness;
    private Employee mEmployee;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_health, container, false);

        mHeight = (TextView) mRootView.findViewById(R.id.textView_height);
        mWeight = (TextView) mRootView.findViewById(R.id.textView_weight);
        mBloodRate = (TextView) mRootView.findViewById(R.id.textView_Blood_rate);
        mBBM = (TextView) mRootView.findViewById(R.id.textView_BBM);
        mBloodPressure = (TextView) mRootView.findViewById(R.id.textview_bloodpresure);
        mParacetemol = (TextView) mRootView.findViewById(R.id.textView_paracetamol);
        mAmoxin = (TextView) mRootView.findViewById(R.id.textView_Amoxin);
        mFloxin = (TextView) mRootView.findViewById(R.id.textView_Floxin);
        mSugar = (CheckBox) mRootView.findViewById(R.id.checkbox_sugar);
        mCancer = (CheckBox) mRootView.findViewById(R.id.checkbox_cancer);
        mMalaria = (CheckBox) mRootView.findViewById(R.id.checkbox_malaria);
        mNightBlindness = (CheckBox) mRootView.findViewById(R.id.checkbox_nightblindness);
////////////////////////////////////////////////////////////////////////////////////////////////
        mEmployee = getArguments().getParcelable("Employee Health");
        mHeight.setText(mEmployee.employeeHealth.getmHeight());
        mWeight.setText(String.valueOf(mEmployee.employeeHealth.getmWeight()));
        mBloodRate.setText(String.valueOf(mEmployee.employeeHealth.getmBloodRate()));
        mBBM.setText(mEmployee.employeeHealth.getmBBM());
        mBloodPressure.setText(mEmployee.employeeHealth.getmBP());
        mParacetemol.setText(String.valueOf(mEmployee.employeeHealth.getmParacetemol()));
        mAmoxin.setText(String.valueOf(mEmployee.employeeHealth.getmAmoxin()));
        mFloxin.setText(String.valueOf(mEmployee.employeeHealth.getmFloxin()));
        mSugar.setChecked(mEmployee.employeeHealth.ismSugar());
        mCancer.setChecked(mEmployee.employeeHealth.ismCancer());
        mMalaria.setChecked(mEmployee.employeeHealth.ismMalaria());
        mNightBlindness.setChecked(mEmployee.employeeHealth.ismNightBlindness());
        return mRootView;
    }
}
