package com.example.lvtn_android.screens.plash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lvtn_android.R;
import com.example.lvtn_android.screens.login.LoginActivity;

public class PlashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.SplashTheme);
//        setContentView(R.layout.activity_plash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent toLogin = new Intent(PlashActivity.this, LoginActivity.class);
                startActivity(toLogin);
                finish();
            }
        }, 1000);


    }
}
