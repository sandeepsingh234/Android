package com.example.corefield.fieldjob.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.corefield.fieldjob.DTO.Employee;
import com.example.corefield.fieldjob.R;


public class EmployeeDetailsFragment extends Fragment implements AdapterView.OnItemSelectedListener


{
    private TextView mName, mAge, mDepartment, mDesignation, mGender, mTempAddress, mPerAdress;
    private String[] mDocument = {"PASSPORT", "DL", "ADAHAR", "VOTE", "PAN"};
    private View mRootView;
    private Employee mEmployee;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_detailss, container, false);
        inIt();
        Spinner spinner = (Spinner) mRootView.findViewById(R.id.spinner_document);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, mDocument);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        return mRootView;
    }

    private void inIt() {
        mName = (TextView) mRootView.findViewById(R.id.textView_name_details);
        mAge = (TextView) mRootView.findViewById(R.id.textView_age_details);
        mDepartment = (TextView) mRootView.findViewById(R.id.textView_dep_details);
        mDesignation = (TextView) mRootView.findViewById(R.id.textView_des_details);
        mGender = (TextView) mRootView.findViewById(R.id.textView_gender);
        mTempAddress = (TextView) mRootView.findViewById(R.id.textView_address_details_temp);
        mPerAdress = (TextView) mRootView.findViewById(R.id.textView_address_details_par);
        setData();
        mTempAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:28.4528393,77.0656347");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        mPerAdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:18.5437111,73.9049944");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
    }

    public void onNothingSelected(AdapterView<?> arg0) {
    }

    public void setData() {
        mEmployee = getArguments().getParcelable("Employee");
        mName.setText(mEmployee.getmName());
        mAge.setText(String.valueOf(mEmployee.getmAge()));
        mDepartment.setText(mEmployee.getmDepartment());
        mDesignation.setText(mEmployee.getmDesignation());
        mGender.setText(mEmployee.getmGender());

    }


}


