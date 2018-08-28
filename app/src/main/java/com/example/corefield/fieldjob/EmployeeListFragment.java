package com.example.corefield.fieldjob;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListFragment extends Fragment implements AdapterView.OnItemClickListener {
    public List<Employee> mEmployeeList;
    private ListView mListView;
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.emloyee_list, container, false);
        inIt();
        return mRootView;
    }

    private void inIt() {
        mListView = (ListView) mRootView.findViewById(R.id.list_emp);
        empDataSet();
        EmployeeListAdapter adapter = new EmployeeListAdapter(getActivity(), R.layout.employee, mEmployeeList);
        mListView.setAdapter(adapter);// adapter to list view
        mListView.setOnItemClickListener(this);
    }

    private void empDataSet() {
        mEmployeeList = new ArrayList<Employee>();
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
        mEmployeeList.add(new Employee(29, R.drawable.e4, "Saven Rozer Bil", "test", "sr", "Male"));
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
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Employee Employee = mEmployeeList.get(position);
        FragmentManager fragmentManager = getFragmentManager();
        EmployeeDetailsFragment employeedetails = new EmployeeDetailsFragment();
        Bundle args = new Bundle();
        args.putString("Name", Employee.getmName());
        args.putString("Age", String.valueOf(Employee.getmAge()));
        args.putString("Dep", Employee.getmDepartment());
        args.putString("Des", Employee.getmDesignation());
        args.putString("Gender", Employee.getmGender());
        args.putInt("Image", Employee.getmImage());
        employeedetails.setArguments(args);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.list, employeedetails, "EmloyeeList fragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
