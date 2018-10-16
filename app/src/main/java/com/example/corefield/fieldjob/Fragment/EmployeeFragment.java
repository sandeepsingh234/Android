package com.example.corefield.fieldjob.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.corefield.fieldjob.DTO.Employee;
import com.example.corefield.fieldjob.R;
import com.squareup.picasso.Picasso;

import info.hoang8f.android.segmented.SegmentedGroup;


public class EmployeeFragment extends Fragment {
    private ImageView mImage;
    private View mRootView;
    private Employee mEmployee;
    private SegmentedGroup mSegmented;
    private ImageButton mGps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.segment_container, container, false);
        inIt();
        mSegmented = (SegmentedGroup) mRootView.findViewById(R.id.segmented);
        mGps = (ImageButton) mRootView.findViewById(R.id.gps);
        final Animation blink = AnimationUtils.loadAnimation(getActivity(), R.anim.blink);
        mGps.startAnimation(blink);
        mSegmented.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.button_health:
                        FragmentManager fragmentManager = getChildFragmentManager();
                        HealthFragment healthFragment = new HealthFragment();
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("Employee Health", mEmployee);
                        healthFragment.setArguments(bundle2);
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.animator.slide_up, R.animator.slide_down);
                        fragmentTransaction.replace(R.id.container_Employee, healthFragment, "Health fragment");
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case R.id.button_about:
                        FragmentManager fragmentManager3 = getChildFragmentManager();
                        EmployeeDetailsFragment employeeDetailsFragment = new EmployeeDetailsFragment();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("Employee", mEmployee);
                        employeeDetailsFragment.setArguments(bundle);
                        FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                        fragmentTransaction3.setCustomAnimations(R.animator.slide_up, R.animator.slide_down);
                        fragmentTransaction3.add(R.id.container_Employee, employeeDetailsFragment, "Details fragment");
                        fragmentTransaction3.addToBackStack(null);
                        fragmentTransaction3.commit();
                        break;
                    case R.id.button_salary:
                        FragmentManager fragmentManager2 = getChildFragmentManager();
                        SalaryFragment salaryFragment = new SalaryFragment();
                        Bundle bundle1 = new Bundle();
                        bundle1.putParcelable("Employee Salary", mEmployee);
                        salaryFragment.setArguments(bundle1);
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        fragmentTransaction2.setCustomAnimations(R.animator.slide_up, R.animator.slide_down);
                        fragmentTransaction2.replace(R.id.container_Employee, salaryFragment, "salary fragment");
                        fragmentTransaction2.addToBackStack(null);
                        fragmentTransaction2.commit();
                        break;

                    default:

                }
            }
        });

        mGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager2 = getFragmentManager();
                MapFragment mapFragment = new MapFragment();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.setCustomAnimations(R.animator.slide_up, R.animator.slide_down);
                fragmentTransaction2.add(R.id.list, mapFragment, "Map fragment");
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
            }
        });

        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });
        return mRootView;
    }

    private void inIt() {
        mImage = (ImageView) mRootView.findViewById(R.id.imageView_emp_details);
        setData();

        FragmentManager fragmentManager3 = getChildFragmentManager();
        EmployeeDetailsFragment employeeDetailsFragment = new EmployeeDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("Employee", mEmployee);
        employeeDetailsFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
        fragmentTransaction3.add(R.id.container_Employee, employeeDetailsFragment, "Details fragment");
        fragmentTransaction3.addToBackStack(null);
        fragmentTransaction3.commit();
    }

    public void setData() {
        mEmployee = getArguments().getParcelable("Employee");
        Picasso.with(getActivity()).load(mEmployee.getmImage()).fit().centerInside().into(mImage);
        /*mImage.setImageResource(mEmployee.getmImage());*/
    }
}


