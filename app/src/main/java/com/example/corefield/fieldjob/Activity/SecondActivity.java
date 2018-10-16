package com.example.corefield.fieldjob.Activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.corefield.fieldjob.Fragment.CoreFieldFragment;
import com.example.corefield.fieldjob.Fragment.EmployeeListFragment;
import com.example.corefield.fieldjob.R;

public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inIt();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.about) {
            Toast toast = Toast.makeText(this, "FieldMobile © CoreField", Toast.LENGTH_LONG);
            toast.show();
        } else if (id == R.id.employeelist) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.field_report) {
            Toast toast = Toast.makeText(this, "Field Report", Toast.LENGTH_LONG);
            toast.show();
        } else if (id == R.id.attendance) {
            Toast toast = Toast.makeText(this, "Checked", Toast.LENGTH_LONG);
            toast.show();
        } else if (id == R.id.company) {
            Intent browserIntent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://corefieldtech.com/"));
            startActivity(browserIntent);

        } else if (id == R.id.coreField) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            CoreFieldFragment coreFieldFragment = new CoreFieldFragment();
            fragmentTransaction.setCustomAnimations(R.animator.slide_up, R.animator.slide_down);
            fragmentTransaction.add(R.id.list, coreFieldFragment, "Corefield fragment");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (id == R.id.logout) {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void inIt()

    {

        ////navigation Drawer///actionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ////////////////////////
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EmployeeListFragment employeeListFragment = new EmployeeListFragment();
        fragmentTransaction.add(R.id.list, employeeListFragment, "EmloyeeList fragment");
        fragmentTransaction.commit();

    }

}

