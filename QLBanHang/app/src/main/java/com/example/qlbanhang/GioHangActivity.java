package com.example.qlbanhang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GioHangActivity extends AppCompatActivity {
    Toolbar toolbargiohang;
    Button btnthanhtoan, btntieptucmua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        ActionToolbar();
        EventButton();
    }

    private void EventButton() {
        btntieptucmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),ThongTinKhachHangActivity.class);
                    startActivity(intent);

            }
        });
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbargiohang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbargiohang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void AnhXa(){
        toolbargiohang = (Toolbar) findViewById(R.id.toolbargiohang);
        btnthanhtoan = (Button) findViewById(R.id.buttonthanhtoangiohang);
        btntieptucmua = (Button) findViewById(R.id.buttontieptucmuahang);
    }
}