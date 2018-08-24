package com.example.corefield.fieldjob;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class EmployeeDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageView mImage;
    private TextView mName, mAge, mDepartment, mDesignation, mGender, mEmail, mTempAddress, mPerAdress;
    private String[] mDocument = {"PASSPORT", "DL", "ADAHAR", "VOTE", "PAN"};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();

        mImage = (ImageView) findViewById(R.id.imageView_emp_details);
        mName = (TextView) findViewById(R.id.textView_name_details);
        mAge = (TextView) findViewById(R.id.textView_age_details);
        mDepartment = (TextView) findViewById(R.id.textView_dep_details);
        mDesignation = (TextView) findViewById(R.id.textView_des_details);
        mGender = (TextView) findViewById(R.id.textView_gender);
        mEmail = (TextView) findViewById(R.id.textView_email_details);
        mTempAddress = (TextView) findViewById(R.id.textView_address_details_temp);
        mPerAdress = (TextView) findViewById(R.id.textView_address_details_par);

        //span text//////////////////////////////////////////////////////////////////////////
        SpannableStringBuilder str = new SpannableStringBuilder("bold");
        str.setSpan(new StyleSpan(Typeface.BOLD), 0,
                4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //span ends///////////////////////////////////////////////////////////////////////////

        /* mEmail.setText(str);*/

        mName.setText(getIntent().getStringExtra("Name"));
        mAge.setText("Age: " + getIntent().getStringExtra("Age"));
        mDepartment.setText("Department: " + getIntent().getStringExtra("Dep"));
        mDesignation.setText("Designation: " + getIntent().getStringExtra("Des"));
        mGender.setText("Gender: " + getIntent().getStringExtra("Gender"));
        int image = bundle.getInt("Image");
        mImage.setImageResource(image);

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


        Spinner spin = (Spinner) findViewById(R.id.spinner_document);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mDocument);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

    }


    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
    }

    public void onNothingSelected(AdapterView<?> arg0) {
    }
  /*  public Spannable fr(String word){
        Spannable WordtoSpan = new SpannableString(word);
        WordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0,
                word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        WordtoSpan.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0,
                word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return WordtoSpan;
    }*/
}

