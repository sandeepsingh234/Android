package com.example.corefield.fieldjob.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.corefield.fieldjob.Activity.SecondActivity;
import com.example.corefield.fieldjob.DTO.Employee;
import com.example.corefield.fieldjob.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

public class ZoomFragment extends Fragment {


    private View mRootView;
    private PhotoView mImage;
    private Employee employee;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.zoom, container, false);
        mImage = mRootView.findViewById(R.id.expanded_image);
        employee = getArguments().getParcelable("Employee");
        Picasso.with(getActivity()).load(employee.getmImage()).fit().centerInside().into(mImage);
        /*  mImage.setImageResource(employee.getmImage());*/


        return mRootView;
    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }
}
