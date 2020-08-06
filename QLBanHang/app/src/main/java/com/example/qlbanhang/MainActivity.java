package com.example.qlbanhang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnThem;
    ListView lvDienThoai;
    ArrayList<DienThoai> arrayListDienThoai;
    DienThoaiAdapter adapter;
    ImageView imgbuttonAdd;
    public static Database database;
    Toolbar toolbardienthoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThem = (Button) findViewById(R.id.buttonThem);
        lvDienThoai = (ListView)findViewById(R.id.listviewdienthoai);

        imgbuttonAdd = (ImageView)findViewById(R.id.imagebuttonAdd);
        toolbardienthoai = (Toolbar) findViewById(R.id.toolbardienthoai);
        arrayListDienThoai = new ArrayList<>();

        adapter = new DienThoaiAdapter(this,R.layout.dong_dienthoai, arrayListDienThoai);
        lvDienThoai.setAdapter(adapter);

        imgbuttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ThemSanPhamDienThoai.class);
                startActivity(intent);
            }
        });

        lvDienThoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ChiTietSanPham.class);
                startActivity(intent);
            }
        });

        //tao bang
        database= new Database(this,"sanpham.sqlite", null, 1);

        //tao bang Dien Thoai
        database.QueryData("CREATE TABLE IF NOT EXISTS DienThoai(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenSanPham VARCHAR(150), GiaSanPham VARCHAR(150), MoTaSanPham VARCHAR(250), HinhAnh BLOB)");

        //get data
        GetData();
        ActionToolbar();
    }



    private void ActionToolbar() {
        setSupportActionBar(toolbardienthoai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbardienthoai.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetData(){
        Cursor cursor = database.GetData("SELECT * FROM DienThoai");
        arrayListDienThoai.clear();
        while (cursor.moveToNext()){
            arrayListDienThoai.add(new DienThoai(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getBlob(4)
            ));
        }
        adapter.notifyDataSetChanged();
    }

    public void DialogXoaSanPham(final String tensp, final int id){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage(" Bạn có muốn xóa sản phẩm " + tensp + " không? ");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.QueryData("DELETE FROM DienThoai WHERE Id = '"+ id +"'");
                Toast.makeText(MainActivity.this, "Đã xóa " + tensp,Toast.LENGTH_SHORT).show();
                GetData();

            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();
    }

    public void DialogSuaSanPham(String ten, final int id){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_sua_san_pham_dien_thoai);

        final EditText edtTenSanPham = (EditText) dialog.findViewById(R.id.edittextsuatensanpham);
        Button btnXacNhan = (Button) dialog.findViewById(R.id.buttonCapNhat);
        Button btnHuy = (Button) dialog.findViewById(R.id.buttonhuy);

        edtTenSanPham.setText(ten);


        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenMoi = edtTenSanPham.getText().toString().trim();
                database.QueryData("UPDATE DienThoai SET TenSanPham = '"+ tenMoi +"' WHERE Id = '"+ id +"'");
                Toast.makeText(MainActivity.this, "Đã cập nhật",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                GetData();

            }
        });


        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}