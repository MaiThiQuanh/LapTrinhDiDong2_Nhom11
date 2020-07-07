package com.example.thucdonnhahang.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.thucdonnhahang.Model.MonAn;
import com.example.thucdonnhahang.Adapter.MonAnAdapter;
import com.example.thucdonnhahang.R;
import com.example.thucdonnhahang.Data.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MonAnActivity extends AppCompatActivity {
    Toolbar toolbarmonan;
    ListView lvmonan;
    MonAnAdapter monAnAdapter;
    ArrayList<MonAn> mangmonan;
    int idmonan = 0;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_an);
        AnhXa();
        GetIdloaimonan();
        ActionToolbar();
        GetData(page);
        LoadMoreData();
    }

    private void LoadMoreData() {

        lvmonan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ChiTietMonAnActivity.class);
                intent.putExtra("thongtinmonan",mangmonan.get(position));
                startActivity(intent);
            }
        });

    }

    private void GetData(int Page) {
        //Doc du lieu tu mot duong dan
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.Duongdanmonan+String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String Tenmonan = "";
                int Giamonan = 0;
                String Hinhanhmonan = "";
                String Mota = "";
                int Idmonan = 0;
                if (response != null){
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++ ){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            Tenmonan = jsonObject.getString("tenmonan");
                            Giamonan = jsonObject.getInt("giamonan");
                            Hinhanhmonan = jsonObject.getString("hinhanhmonan");
                            Mota = jsonObject.getString("motamonan");
                            Idmonan = jsonObject.getInt("idmonan");
                            mangmonan.add(new MonAn(id,Tenmonan,Giamonan,Hinhanhmonan,Mota,Idmonan));
                            monAnAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            //Gui gia tri len server
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<String, String>();
                param.put("idmonan",String.valueOf(idmonan));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    //Toolbar tro ve man hinh truoc
    private void ActionToolbar() {
        setSupportActionBar(toolbarmonan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarmonan.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetIdloaimonan() {
        idmonan = getIntent().getIntExtra("idloaimonan",-1);
        Log.d("giatriloaimonan",idmonan+"");
    }

    private void AnhXa() {
        toolbarmonan = (Toolbar) findViewById(R.id.toolbarmonan);
        lvmonan = (ListView) findViewById(R.id.listviewmonan);
        mangmonan = new ArrayList<>();
        monAnAdapter = new MonAnAdapter(getApplicationContext(),mangmonan);
        lvmonan.setAdapter(monAnAdapter);
    }


}