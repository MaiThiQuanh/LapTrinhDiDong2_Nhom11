package com.example.qlbanhang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TrangChuActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;
    ArrayList<Loaisp> mangloaisp;
    LoaiSanPhamAdapter loaispAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        AnhXa();
        ActionBar();
        ActionViewFlipper();
        GetDuLieuLoaisp();
        CatchOnItemListView();
    }

    private void CatchOnItemListView() {
        listViewmanhinhchinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(TrangChuActivity.this,TrangChuActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(TrangChuActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(TrangChuActivity.this, LienHeActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(TrangChuActivity.this, ThongTinActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(TrangChuActivity.this, ThongKeActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    private void GetDuLieuLoaisp()
    {
        mangloaisp.add(1,new Loaisp(0,"Điện Thoại","https://iconsgalore.com/wp-content/uploads/2018/10/cell-phone-1-featured-2.png"));
        mangloaisp.add(2,new Loaisp(0,"Liên Hệ","https://daycamhoa.com/wp-content/uploads/2017/07/lien-he.png"));
        mangloaisp.add(3,new Loaisp(0,"Thông Tin","https://cdn2.iconfinder.com/data/icons/rcons-users-color/32/support_woman-512.png"));
        mangloaisp.add(4,new Loaisp(0,"Thống Kê","https://image.flaticon.com/icons/png/512/1321/1321907.png"));

    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://tikicdn.com/media/catalog/product/j/7/j7pro-preorder-kv-v1.u3059.d20170613.t112936.249930.jpg");
        mangquangcao.add("https://chamsocdidong.com/wp-content/uploads/2019/04/5-dau-hieu-bao-dong-can-thay-pin-iphone-de-tranh-chay-no-ava.jpg");
        mangquangcao.add("https://i.ytimg.com/vi/36HnmEcKDJk/maxresdefault.jpg");
        mangquangcao.add("https://media1.nguoiduatin.vn/media/vu-kim-linh/2018/08/13/smartphone-gia-duoi-5-trieu-dang-dong-tien-bat-gao-2.jpg");

        for (int i = 0; i < mangquangcao.size(); i++)
        {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        //Gan animation
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void AnhXa() {
        toolbar = (Toolbar) findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewlipper);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        listViewmanhinhchinh = (ListView) findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mangloaisp = new ArrayList<>();
        mangloaisp.add(0,new Loaisp(0,"Trang Chủ","https://leph2018toronto.com/wp-content/uploads/2018/02/house-icon.png"));
        loaispAdapter = new LoaiSanPhamAdapter(mangloaisp,getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaispAdapter);
    }

}