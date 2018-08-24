package com.example.corefield.fieldjob;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EmployeeListAdapter extends ArrayAdapter<Employee> {

    private Context mContext;
    int resource;
    private List<Employee> EmployeeList;

    private TextView mTextView_age, mTextView_des, mTextView_name, mTextView_dep;
    private ImageView mImageView_emp;
    private Button mButton_Delete;

    public EmployeeListAdapter(Context mct, int resource, List<Employee> Employee_List)

    {

        super(mct, resource, Employee_List);
        this.mContext = mct;
        this.resource = resource;
        this.EmployeeList = Employee_List;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.employee, null);

        mImageView_emp = (ImageView) view.findViewById(R.id.imageView_emp);
        mTextView_name = (TextView) view.findViewById(R.id.textView_name);
        mTextView_age = (TextView) view.findViewById(R.id.textView_age);
        mTextView_des = (TextView) view.findViewById(R.id.textView_des);
        mTextView_dep = (TextView) view.findViewById(R.id.textView_dep);
        mButton_Delete = (Button) view.findViewById(R.id.button_delete);
        //span text////////////////////////////////////////////////////////////////////
        SpannableStringBuilder str = new SpannableStringBuilder("bold");
        str.setSpan(new StyleSpan(Typeface.BOLD), 0,
                4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //span ends/////////////////////////////////////////////////////////////////////
        Employee Employee = EmployeeList.get(position);

        mTextView_name.setText(Employee.getmName());
        mTextView_dep.setText("Department: " + Employee.getmDepartment());
        mTextView_age.setText("Age: " + String.valueOf(Employee.getmAge()));
        mTextView_des.setText("Designation: " + Employee.getmDesignation());

        mImageView_emp.setImageDrawable(mContext.getResources().getDrawable(Employee.getmImage()));


        mButton_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeEmployee(position);
            }
        });

        return view;
    }

    private void removeEmployee(final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Are you sure you want to delete this?");


        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                EmployeeList.remove(position);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}