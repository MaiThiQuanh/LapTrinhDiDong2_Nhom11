package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.customview.views.CustomView;

public class MainActivity extends AppCompatActivity {

    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomView = (CustomView) findViewById(R.id.customView);

        findViewById(R.id.btn_swap_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCustomView.swapColor();

            }
        });



    }
}