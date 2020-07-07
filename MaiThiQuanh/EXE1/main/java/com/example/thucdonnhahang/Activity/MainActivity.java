package com.example.thucdonnhahang.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.thucdonnhahang.Model.CardViewModel;
import com.example.thucdonnhahang.Model.Loaimonan;
import com.example.thucdonnhahang.Adapter.LoaimonanAdapter;
import com.example.thucdonnhahang.Adapter.MyRecyclerViewAdapter;
import com.example.thucdonnhahang.R;
import com.example.thucdonnhahang.Data.Server;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    RecyclerView recyclerViewmanhinhchinh;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;

    private Vector<CardViewModel> data;
    RecyclerView recyclerView;
    ArrayList<Loaimonan> mangloaimonan;
    LoaimonanAdapter loaimonanAdapter;
    int id = 0;
    String tenloaimonan = "";
    String hinhanhloaimonan = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ActionBar();
        GetDuLieuLoaimonan();
        CatchOnItemListView();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //Initiation of data
        data = new Vector<CardViewModel>();
        data.add(new CardViewModel("Hinh 1", R.drawable.nen1));
        data.add(new CardViewModel("Hinh 2", R.drawable.nen2));
        data.add(new CardViewModel("Hinh 3", R.drawable.nen3));

        //Setup Recycler View
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
       
        recyclerView.setLayoutManager(layoutManager);

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(R.layout.card_view_layout, data);
        recyclerView.setAdapter(adapter);
    }

    //Listview man hinh menu va bat su kien khi click vao
    private void CatchOnItemListView() {
        listViewmanhinhchinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    //Vi tri thu 0 la trang chu bat su kien se tro ve trang chu
                    case 0:
                        Intent intent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                        //Đóng thanh menu
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, MonAnActivity.class);
                        //putEXtra chuyen du lieu sang mang hinh khac
                        intent.putExtra("idloaimonan",mangloaimonan.get(position).getId());
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }

    //Do du lieu vao thanh menu
    private void GetDuLieuLoaimonan() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongdanLoaimonan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null){
                    for (int i = 0; i < response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenloaimonan = jsonObject.getString("tenloaimonan");
                            hinhanhloaimonan = jsonObject.getString("hinhanhloaimonan");
                            mangloaimonan.add(new Loaimonan(id,tenloaimonan,hinhanhloaimonan));
                            loaimonanAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        //Bat su kien khi click vao menu thi se mo ra thanh menu
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void AnhXa() {
        toolbar = (Toolbar) findViewById(R.id.toolbarmanhinhchinh);
        recyclerViewmanhinhchinh = (RecyclerView) findViewById(R.id.recyclerView);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        listViewmanhinhchinh = (ListView) findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mangloaimonan = new ArrayList<>();
        mangloaimonan.add(0,new Loaimonan(0,"Nhà Hàng","https://cdn.iconscout.com/icon/free/png-512/work-from-home-1956276-1650439.png"));
        loaimonanAdapter = new LoaimonanAdapter(mangloaimonan,getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaimonanAdapter);

    }
}