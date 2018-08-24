package com.example.corefield.fieldjob;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class EmployeeListActivity extends Activity {
    public List<Employee> mEmployeeList;
    private ListView mListView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emloyee_list);

        mEmployeeList = new ArrayList<Employee>();
        mListView = (ListView) findViewById(R.id.list_emp);


        mEmployeeList.add(new Employee(29, R.drawable.e1, "Marry", "Test", "Sr", "Female"));
        mEmployeeList.add(new Employee(21, R.drawable.e2, "Bill", "Dev", "Sr", "Male"));
        mEmployeeList.add(new Employee(23, R.drawable.e3, "Jhon", "Q&A", "jr", "Male"));
        mEmployeeList.add(new Employee(29, R.drawable.e4, "Saven", "test", "sr", "Male"));
        mEmployeeList.add(new Employee(21, R.drawable.e5, "Rumy kumari ayyer", "Dev", "sr", "Female"));
        mEmployeeList.add(new Employee(23, R.drawable.e6, "Karry", "Q&A", "jr", "Female"));
        mEmployeeList.add(new Employee(29, R.drawable.e7, "Maven", "test", "Sr", "Male"));
        mEmployeeList.add(new Employee(23, R.drawable.e9, "lara", "Q&A", "jr", "Female"));
        mEmployeeList.add(new Employee(29, R.drawable.e1, "Marry", "Test", "Sr", "Female"));
        mEmployeeList.add(new Employee(21, R.drawable.e2, "Bill", "Dev", "Sr", "Male"));
        mEmployeeList.add(new Employee(23, R.drawable.e3, "Jhon", "Q&A", "jr", "Male"));
        mEmployeeList.add(new Employee(29, R.drawable.e4, "Saven rozer bil", "test", "sr", "Male"));
        mEmployeeList.add(new Employee(21, R.drawable.e5, "Rumy", "Dev", "sr", "Female"));
        mEmployeeList.add(new Employee(23, R.drawable.e6, "Karry", "Q&A", "jr", "Female"));
        mEmployeeList.add(new Employee(29, R.drawable.e7, "Maven", "test", "Sr", "Male"));
        mEmployeeList.add(new Employee(21, R.drawable.e8, "Sameera", "Dev", "sr", "Female"));
        mEmployeeList.add(new Employee(23, R.drawable.e9, "lara dutta", "Q&A", "jr", "Female"));
        mEmployeeList.add(new Employee(29, R.drawable.e1, "Marry", "Test", "Sr", "Female"));
        mEmployeeList.add(new Employee(21, R.drawable.e2, "Bill", "Dev", "Sr", "Male"));
        mEmployeeList.add(new Employee(23, R.drawable.e3, "Jhon", "Q&A", "jr", "Male"));
        mEmployeeList.add(new Employee(29, R.drawable.e4, "Saven", "test", "sr", "Male"));
        mEmployeeList.add(new Employee(21, R.drawable.e5, "Rumy", "Dev", "sr", "Female"));
        mEmployeeList.add(new Employee(23, R.drawable.e6, "Karry mahnata", "Q&A", "jr", "Female"));
        mEmployeeList.add(new Employee(29, R.drawable.e7, "Maven", "test", "Sr", "Male"));
        mEmployeeList.add(new Employee(21, R.drawable.e8, "Sameera", "Dev", "sr", "Female"));
        mEmployeeList.add(new Employee(21, R.drawable.e8, "Sameera", "Dev", "sr", "Female"));
        mEmployeeList.add(new Employee(23, R.drawable.e9, "lara", "Q&A", "jr", "Female"));


        EmployeeListAdapter adapter = new EmployeeListAdapter(this, R.layout.employee, mEmployeeList);
        mListView.setAdapter(adapter);// adapter to list view

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Employee Employee = mEmployeeList.get(position);

                Intent intent = new Intent(EmployeeListActivity.this, EmployeeDetails.class);

                intent.putExtra("Name", Employee.getmName());
                intent.putExtra("Age", String.valueOf(Employee.getmAge()));
                intent.putExtra("Dep", Employee.getmDepartment());
                intent.putExtra("Image", Employee.getmImage());
                intent.putExtra("Des", Employee.getmDesignation());
                intent.putExtra("Gender", Employee.getmGender());
                startActivity(intent);

            }
        });
    }


}

