package com.example.thucdonnhahang.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thucdonnhahang.Model.MonAn;
import com.example.thucdonnhahang.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;


public class ChiTietMonAnActivity extends AppCompatActivity {

    Toolbar toolbarChiTiet;
    ImageView imgChiTiet;
    TextView txtten, txtgia, txtmota;
    Button btndatmon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_mon_an);
        AnhXa();
        ActionToolbar();
        GetInformation();
    }


    private void GetInformation() {
        int id = 0;
        String TenChitiet = "";
        int GiaChitiet = 0;
        String HinhanhChitiet = "";
        String MotaChitiet = "";
        int Idsanpham = 0;

        MonAn monAn = (MonAn) getIntent().getSerializableExtra("thongtinmonan");
        id = monAn.getID();
        TenChitiet = monAn.getTenmonan();
        GiaChitiet = monAn.getGiamonan();
        HinhanhChitiet = monAn.getHinhanhmonan();
        MotaChitiet = monAn.getMotamonan();
        Idsanpham = monAn.getIDMonan();
        txtten.setText(TenChitiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        txtgia.setText("Giá : " + decimalFormat.format(GiaChitiet) + "đ");
        txtmota.setText(MotaChitiet);
        Picasso.with(getApplicationContext()).load(HinhanhChitiet).into(imgChiTiet);

    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarChiTiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChiTiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void AnhXa() {
        toolbarChiTiet = (Toolbar) findViewById(R.id.toolbarchitietmonan);
        imgChiTiet = (ImageView) findViewById(R.id.imageviewchitietmonan);
        txtten = (TextView) findViewById(R.id.textviewtenchitietmonan);
        txtgia = (TextView) findViewById(R.id.textviewgiachitietmonan);
        txtmota = (TextView)findViewById(R.id.textviewmotachitietmonan);
        btndatmon = (Button)findViewById(R.id.buttondatmon);
        btndatmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChiTietMonAnActivity.this,"Bạn đã đặt món thành công",Toast.LENGTH_SHORT).show();
            }
        });



    }

}