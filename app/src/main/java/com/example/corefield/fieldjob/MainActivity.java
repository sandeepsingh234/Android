package com.example.corefield.fieldjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button login, mLoginButton;
    EditText muser, mpass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.button_login);
        muser = (EditText) findViewById(R.id.editText_user);
        mpass = (EditText) findViewById(R.id.editText_pass);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (muser.getText().toString().equals("admin") && mpass.getText().toString().equals("12345")) {
                    Intent intent = new Intent(MainActivity.this, EmpList.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
