package com.example.quanlybanhang.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashScreenActivit extends AppCompatActivity {

    final long delay = 4000L;
    final Runnable action = new Runnable() {
        public void run() {
            Intent goToMain = new Intent(SplashScreenActivit.this, DangNhapActivity.class);
            startActivity(goToMain);
            finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Handler handler = new Handler();
        handler.postDelayed(action, delay);
    }
}