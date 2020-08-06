package com.example.qlbanhang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;



public class LienHeActivity extends AppCompatActivity {

    Toolbar toolbarlienhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lien_he);
        Anhxa();
        ActionToolbar();
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarlienhe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarlienhe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbarlienhe = (Toolbar) findViewById(R.id.toolbarlienhe);
    }
}