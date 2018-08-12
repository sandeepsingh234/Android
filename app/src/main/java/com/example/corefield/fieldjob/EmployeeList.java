package com.example.corefield.fieldjob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class EmployeeList extends ArrayAdapter<Employee> {

    Context mct;
    int resource;
    List<Employee> Employee_List;

    public EmployeeList(Context mct, int resource, List<Employee> Employee_List)

    {

        super(mct, resource, Employee_List);
        this.mct = mct;
        this.resource = resource;
        this.Employee_List = Employee_List;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(mct);

        View view = layoutInflater.inflate(R.layout.employee, null);


        ImageView imageView = (ImageView) view.findViewById(R.id.emp);
        TextView textView_name = (TextView) view.findViewById(R.id.textView_name);
        TextView textView_age = (TextView) view.findViewById(R.id.textView_age);
        TextView textView_des = (TextView) view.findViewById(R.id.textView_des);
        TextView textView_dep = (TextView) view.findViewById(R.id.textView_dep);

        Employee Employee = Employee_List.get(position);
        textView_name.setText(Employee.getNAME());
        textView_dep.setText(Employee.getDEPARTMENT());
        textView_age.setText(Employee.getAGE());
        textView_des.setText(Employee.getDESIGNATION());


        imageView.setImageDrawable(mct.getResources().getDrawable(Employee.getIMAGE()));

        return view;
    }

}

