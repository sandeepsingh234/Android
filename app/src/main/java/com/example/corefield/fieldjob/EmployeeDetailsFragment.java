package com.example.corefield.fieldjob;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class EmployeeDetailsFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener


{
    private ImageView mImage;
    private TextView mName, mAge, mDepartment, mDesignation, mGender, mEmail, mTempAddress, mPerAdress;
    private String[] mDocument = {"PASSPORT", "DL", "ADAHAR", "VOTE", "PAN"};
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.activity_details, container, false);
        inIt();
        spinner();
        return mRootView;
    }

    private void inIt() {
        viewIt();
        setIt();
        mEmail.setOnClickListener(this);
        mPerAdress.setOnClickListener(this);
        mTempAddress.setOnClickListener(this);
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
    }

    public void onNothingSelected(AdapterView<?> arg0) {
    }

    public void viewIt() {
        mImage = (ImageView) mRootView.findViewById(R.id.imageView_emp_details);
        mName = (TextView) mRootView.findViewById(R.id.textView_name_details);
        mAge = (TextView) mRootView.findViewById(R.id.textView_age_details);
        mDepartment = (TextView) mRootView.findViewById(R.id.textView_dep_details);
        mDesignation = (TextView) mRootView.findViewById(R.id.textView_des_details);
        mGender = (TextView) mRootView.findViewById(R.id.textView_gender);
        mEmail = (TextView) mRootView.findViewById(R.id.textView_email_details);
        mTempAddress = (TextView) mRootView.findViewById(R.id.textView_address_details_temp);
        mPerAdress = (TextView) mRootView.findViewById(R.id.textView_address_details_par);
    }

    public void setIt() {
        mName.setText(getArguments().getString("Name"));
        mAge.setText(getArguments().getString("Age"));
        mDepartment.setText(getArguments().getString("Dep"));
        mDesignation.setText(getArguments().getString("Des"));
        mGender.setText(getArguments().getString("Gender"));
        mImage.setImageResource(getArguments().getInt("Image"));
    }

    public void spinner() {
        Spinner spin = (Spinner) mRootView.findViewById(R.id.spinner_document);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, mDocument);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    @Override
    public void onClick(View view) {
        mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                startActivity(emailIntent);
            }
        });
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
}


