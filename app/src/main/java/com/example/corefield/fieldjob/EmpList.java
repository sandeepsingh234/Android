package com.example.corefield.fieldjob;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class EmpList extends AppCompatActivity
{
    List<Employee>employeeList;
    ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emloyee_list);

        employeeList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list_emp);

        employeeList.add(new Employee(29,R.drawable.e1,"bill","sre","sr"));
        employeeList.add(new Employee(21,R.drawable.e2,"marry","muc","sr"));
        employeeList.add(new Employee(23,R.drawable.e3,"jhon","sre","jr"));

        EmployeeList adapter=new EmployeeList(this,R.layout.employee,employeeList);
        listView.setAdapter(adapter);

    }

    }
