package com.example.corefield.fieldjob.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.corefield.fieldjob.DTO.Employee;
import com.example.corefield.fieldjob.Listener.RecyclerTouchListener;
import com.example.corefield.fieldjob.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.ViewHolder> {


    private List<Employee> mEmployeeList;
    private LayoutInflater mInflater;
    private Employee mEmployee;
    private Context mContext;
    private RecyclerTouchListener clickListener;
    private int position;

    public EmployeeListAdapter(Context context, int position, List<Employee> mEmployeeList)

    {

        this.mInflater = LayoutInflater.from(context);
        this.mEmployeeList = mEmployeeList;
        this.position = position;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = mInflater.inflate(R.layout.employee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Employee Employee = mEmployeeList.get(position);

        viewHolder.mTextView_name.setText(Employee.getmName());
        viewHolder.mTextView_dep.setText(Employee.getmDepartment());
        viewHolder.mTextView_age.setText(String.valueOf(Employee.getmAge()));
        viewHolder.mTextView_des.setText(Employee.getmDesignation());
        Picasso.with(mContext).load(Employee.getmImage()).fit().centerInside().into(viewHolder.mImageView_emp);
        /* viewHolder.mImageView_emp.setImageDrawable(mContext.getResources().getDrawable(Employee.getmImage()));*/
    }

    @Override
    public int getItemCount() {
        return mEmployeeList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextView_age, mTextView_des, mTextView_name, mTextView_dep;
        private ImageView mImageView_emp;


        ViewHolder(View view) {
            super(view);
            mImageView_emp = (ImageView) view.findViewById(R.id.imageView_emp);
            mTextView_name = (TextView) view.findViewById(R.id.textView_name);
            mTextView_age = (TextView) view.findViewById(R.id.textView_age);
            mTextView_des = (TextView) view.findViewById(R.id.textView_des);
            mTextView_dep = (TextView) view.findViewById(R.id.textView_dep);
            mImageView_emp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onImageClicked(view, getAdapterPosition());
                }
            });
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onClick(view, getAdapterPosition());
                }
            });
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());
        }
    }

    public Employee getItem(int id) {
        return mEmployeeList.get(id);
    }

    public void setClickListener(RecyclerTouchListener itemClickListener) {
        this.clickListener = itemClickListener;

    }
}

