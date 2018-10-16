package com.example.corefield.fieldjob.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.corefield.fieldjob.R;

public class SplashActivity extends Activity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = (ImageView) findViewById(R.id.FM);
        Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        imageView.startAnimation(zoomin);
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
}



