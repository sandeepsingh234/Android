package com.example.corefield.fieldjob;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class SecondActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EmployeeListFragment fragmentActivity = new EmployeeListFragment();
        fragmentTransaction.add(R.id.list, fragmentActivity, "EmloyeeList fragment");
        fragmentTransaction.commit();
    }
}

