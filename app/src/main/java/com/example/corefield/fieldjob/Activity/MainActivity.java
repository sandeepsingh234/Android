package com.example.corefield.fieldjob.Activity;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.corefield.fieldjob.Fragment.LoginFragment;
import com.example.corefield.fieldjob.R;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment fragmentActivity = new LoginFragment();
        fragmentTransaction.add(R.id.login, fragmentActivity, "fragment");
        fragmentTransaction.commit();
    }
}



