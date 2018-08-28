package com.example.corefield.fieldjob;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment

{
    private Button mButton_login;
    private EditText mEditText_user, mEditText_pass;
    private TextView mTextview_Titel;
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_login, container, false);
        inIt();
        return mRootView;
    }

    private void inIt() {
        mButton_login = (Button) mRootView.findViewById(R.id.button_login);
        mEditText_user = (EditText) mRootView.findViewById(R.id.editText_user);
        mEditText_pass = (EditText) mRootView.findViewById(R.id.editText_pass);
        mTextview_Titel = (TextView) mRootView.findViewById(R.id.textView_title);

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/jam.ttf");
        mTextview_Titel.setTypeface(typeface);

        mButton_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mEditText_user.getText().toString().equals("admin") && mEditText_pass.getText().toString().equals("12345")) {
                    Intent intent = new Intent(getActivity(), SecondActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Wrong ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
