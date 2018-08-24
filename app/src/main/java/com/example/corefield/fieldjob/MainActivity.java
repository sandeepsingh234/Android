package com.example.corefield.fieldjob;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private Button mButton_login;
    private EditText mEditText_user, mEditText_pass;
    private TextView mTextview_Titel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton_login = (Button) findViewById(R.id.button_login);
        mEditText_user = (EditText) findViewById(R.id.editText_user);
        mEditText_pass = (EditText) findViewById(R.id.editText_pass);
        mTextview_Titel = (TextView) findViewById(R.id.textView_title);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/jam.ttf");
        mTextview_Titel.setTypeface(typeface);

        mButton_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mEditText_user.getText().toString().equals("admin") && mEditText_pass.getText().toString().equals("12345")) {
                    Intent intent = new Intent(MainActivity.this, EmployeeListActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
