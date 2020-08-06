package com.example.qlbanhang;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DangNhapActivity extends AppCompatActivity {

    EditText edtuser, edtpassword;
    Button btndangky,btndangnhap,btnthoat;
    String ten,mk;

    boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        setEvent();
        AnhXa();
        ControlButton();
    }

    private void setEvent() {
        ImageView cat = (ImageView) findViewById(R.id.imageRotate);
        final AnimationDrawable runningRotate = (AnimationDrawable) cat.getDrawable();
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(running) {
                    runningRotate.start();
                }else {
                    runningRotate.stop();
                }
                running = !running;
            }
        });
    }

    private void ControlButton() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DangNhapActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát");
                builder.setMessage("Hãy lựa chọn bên dưới để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();

                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(DangNhapActivity.this);
                dialog.setTitle("Hộp thoại xử lý");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                final EditText edttk = (EditText)dialog.findViewById(R.id.edttk);
                final EditText edtmk = (EditText)dialog.findViewById(R.id.edtmk);
                Button btnhuy = (Button)dialog.findViewById(R.id.buttonhuy);
                Button btndongy = (Button)dialog.findViewById(R.id.buttondongy);
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();

                        edtuser.setText(ten);
                        edtpassword.setText(mk);

                        dialog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtuser.getText().length() != 0 && edtpassword.getText().length() != 0){
                    if (edtuser.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)){
                        Toast.makeText(DangNhapActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DangNhapActivity.this,TrangChuActivity.class);
                        startActivity(intent);
                    }else if(edtuser.getText().toString().equals("Quanh") && edtpassword.getText().toString().equals("123456")){
                        Toast.makeText(DangNhapActivity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DangNhapActivity.this,TrangChuActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(DangNhapActivity.this,"Bạn đã đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(DangNhapActivity.this,"Mời bạn nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        edtuser = (EditText) findViewById(R.id.edttextuser);
        edtpassword = (EditText) findViewById(R.id.edttextpassword);
        btndangnhap = (Button) findViewById(R.id.buttondangnhap);
        btndangky = (Button) findViewById(R.id.buttondangky);
        btnthoat = (Button) findViewById(R.id.buttonthoat);

    }
}