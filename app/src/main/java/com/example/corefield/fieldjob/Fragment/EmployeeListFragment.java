package com.example.corefield.fieldjob.Fragment;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.corefield.fieldjob.Adapter.EmployeeListAdapter;
import com.example.corefield.fieldjob.DTO.Employee;
import com.example.corefield.fieldjob.DTO.EmployeeHealth;
import com.example.corefield.fieldjob.DTO.EmployeeSalary;
import com.example.corefield.fieldjob.Database.EmployeeDBManager;
import com.example.corefield.fieldjob.Listener.RecyclerTouchListener;
import com.example.corefield.fieldjob.Network.HttpHandler;
import com.example.corefield.fieldjob.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EmployeeListFragment extends Fragment implements RecyclerTouchListener {
    public ArrayList<Employee> mEmployeeList;
    private View mRootView;
    private Employee mEmployee;
    private RecyclerView mRecyclerView;
    private int position;
    private EmployeeListAdapter employeeListAdapter;
    private RecyclerView.LayoutManager mlayoutManager;
    private EmployeeDBManager dbManager;
    private ProgressBar mProgressBar;
    private TextView mNoconnection_text;
    private ImageView mNoconnection_image;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.emloyee_list, container, false);
        mEmployeeList = new ArrayList<>();
        mNoconnection_text = mRootView.findViewById(R.id.nocon);
        mNoconnection_image = mRootView.findViewById(R.id.noconimage);
        mProgressBar = (ProgressBar) mRootView.findViewById(R.id.progress_bar);
        if (isOnline()) {
        } else {
            mNoconnection_image.setVisibility(View.VISIBLE);
            mNoconnection_text.setVisibility(View.VISIBLE);
        }
        new Fetch().execute();
        employeeListAdapter = new EmployeeListAdapter(getActivity(), position, mEmployeeList);
        employeeListAdapter.setClickListener(this);
        return mRootView;
    }

    protected boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }


    private class Fetch extends AsyncTask<String, String, String> {


        protected void onProgressUpdate(Integer... progress) {
            mProgressBar.setProgress(progress[0]);

        }

        @Override
        protected String doInBackground(String... params) {
            HttpHandler httpHandler = new HttpHandler();
            String url = "https://corefield.000webhostapp.com/fw.json";
            String jsonStr = httpHandler.makeServiceCall(url);
            dbManager = new EmployeeDBManager(getActivity());
            dbManager.open();
            jsonparser(jsonStr);
            dbManager.close();
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            mProgressBar.setVisibility(View.INVISIBLE);
            mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.list_emp);
            mRecyclerView.setHasFixedSize(true);
            mlayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mlayoutManager);
            mRecyclerView.setAdapter(employeeListAdapter);
        }
    }

    @Override
    public void onClick(View view, int position) {
        mEmployee = mEmployeeList.get(position);
        FragmentManager fragmentManager = getFragmentManager();
        EmployeeFragment employeeFragment = new EmployeeFragment();
        Bundle args = new Bundle();
        args.putParcelable("Employee", mEmployee);
        employeeFragment.setArguments(args);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.list, employeeFragment, "EmloyeeList fragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onImageClicked(View view, int position) {
        mEmployee = mEmployeeList.get(position);
        FragmentManager fragmentManager = getFragmentManager();
        ZoomFragment zoomFragment = new ZoomFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("Employee", mEmployee);
        zoomFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.list, zoomFragment, "zoom fragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void jsonparser(String jsonStr) {
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                JSONArray employee = jsonObj.getJSONArray("Employee");
                for (int i = 0; i < employee.length(); i++) {

                    JSONObject load = employee.getJSONObject(i);
                    String name = load.getString("name");
                    String imageUrl = load.getString("image");
                    ///////////////////////////////////////////
                    JSONObject about = load.getJSONObject("about"); //about JSON obj
                    String dep = about.getString("dep");
                    String des = about.getString("des");
                    String gender = about.getString("gender");
                    int age = about.getInt("age");

                    ////////////////////////////////////////////////////
                    JSONObject salary = load.getJSONObject("salary");

                    int basicPay = salary.getInt("basicPay");
                    int grossPay = salary.getInt("grossPay");
                    int SSS = salary.getInt("SSS");
                    int Phill = salary.getInt("mPhill");
                    int PAG = salary.getInt("PAG");
                    int nonTax = salary.getInt("nonTax");
                    int TaxA = salary.getInt("TaxA");
                    int TDS = salary.getInt("TDS");
                    int netincome = salary.getInt("netincome");

                    //////////////////////////////////////
                    JSONObject health = load.getJSONObject("health");

                    String Height = health.getString("Height");
                    int Weight = health.getInt("Weight");
                    int BloodRate = health.getInt("BloodRate");
                    String BBM = health.getString("BBM");
                    String BP = health.getString("BP");
                    String Paracetemol = health.getString("Paracetemol");
                    String Amoxin = health.getString("Amoxin");
                    String Floxin = health.getString("Floxin");
                    Boolean Sugar = health.getBoolean("Sugar");
                    Boolean Cancer = health.getBoolean("Cancer");
                    Boolean Malaria = health.getBoolean("Malaria");
                    Boolean NightBlindness = health.getBoolean("NightBlindness");
                    //////////////////////////////////////////
                    mEmployeeList.add(new Employee(age, imageUrl, name, dep, des, gender,
                            new EmployeeSalary(basicPay, nonTax, TaxA, grossPay, SSS, Phill, PAG, TDS, netincome),
                            new EmployeeHealth(Height, Weight, BloodRate, BBM, BP, dep, gender, Paracetemol, Amoxin,
                                    Floxin, Sugar, Cancer, Malaria, NightBlindness)));

                    dbManager.insert(age, imageUrl, name, dep, des, gender, basicPay, nonTax, TaxA, grossPay, SSS,
                            Phill, PAG, TDS, netincome, Height, Weight, BloodRate, BBM, BP, Paracetemol, Amoxin, Floxin
                    );
                }
            } catch (final JSONException e) {

            }
        }
    }
}