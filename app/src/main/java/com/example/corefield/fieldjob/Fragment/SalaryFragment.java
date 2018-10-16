package com.example.corefield.fieldjob.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.corefield.fieldjob.DTO.Employee;
import com.example.corefield.fieldjob.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class SalaryFragment extends Fragment {


    private View mRootView;
    private TextView mBasicPay, mGrossPay, mSSS, mPhill, mPAG, mNonTax, mTaxA, mTDS, mNetincome;
    private Employee mEmployee;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_salary, container, false);
        mBasicPay = (TextView) mRootView.findViewById(R.id.textView_basicpay);
        mGrossPay = (TextView) mRootView.findViewById(R.id.textView_grosspay);
        mSSS = (TextView) mRootView.findViewById(R.id.textView_sss);
        mPhill = (TextView) mRootView.findViewById(R.id.textView_phill);
        mPAG = (TextView) mRootView.findViewById(R.id.textView_PAG);
        mNonTax = (TextView) mRootView.findViewById(R.id.textView_nontax);
        mTaxA = (TextView) mRootView.findViewById(R.id.textView_taxa);
        mTDS = (TextView) mRootView.findViewById(R.id.textView_tds);
        mNetincome = (TextView) mRootView.findViewById(R.id.textView_netincome);


////////////////////////////////////////////////////////////////////////////////////////////////
        mEmployee = getArguments().getParcelable("Employee Salary");
////////////////////////////////////////////////////////////////////////////////////////////////
        mBasicPay.setText("₹ " + String.valueOf(mEmployee.employeeSalary.getmBasicPay() + " /- "));
        mGrossPay.setText("₹ " + String.valueOf(mEmployee.employeeSalary.getmGrossPay() + " /- "));
        mSSS.setText("₹ " + String.valueOf(mEmployee.employeeSalary.getmSSS() + " /- "));
        mPhill.setText("₹ " + String.valueOf(mEmployee.employeeSalary.getmPhill() + " /- "));
        mPAG.setText("₹ " + String.valueOf(mEmployee.employeeSalary.getmPAG() + " /- "));
        mNonTax.setText("₹ " + String.valueOf(mEmployee.employeeSalary.getmNon_Tax() + " /- "));
        mTaxA.setText("₹ " + String.valueOf(mEmployee.employeeSalary.getmTax_A() + " /- "));
        mTDS.setText("₹ " + String.valueOf(mEmployee.employeeSalary.getmTDS() + " /- "));
        mNetincome.setText("₹ " + String.valueOf(mEmployee.employeeSalary.getmNetincome() + " /- "));

        GraphView graph = (GraphView) mRootView.findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(0, mEmployee.employeeSalary.getmBasicPay()),
                new DataPoint(1, mEmployee.employeeSalary.getmGrossPay()),
                new DataPoint(2, mEmployee.employeeSalary.getmSSS()),
                new DataPoint(3, mEmployee.employeeSalary.getmPhill()),
                new DataPoint(4, mEmployee.employeeSalary.getmPAG()),
                new DataPoint(5, mEmployee.employeeSalary.getmNon_Tax()),
                new DataPoint(6, mEmployee.employeeSalary.getmTax_A()),
                new DataPoint(7, mEmployee.employeeSalary.getmTDS()),
                new DataPoint(8, mEmployee.employeeSalary.getmNetincome()),

        });
        graph.addSeries(series);
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX() * 255 / 4, (int) Math.abs(data.getY() * 255 / 6), 100);
            }
        });

        series.setSpacing(5);
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.BLACK);
        return mRootView;
    }
}