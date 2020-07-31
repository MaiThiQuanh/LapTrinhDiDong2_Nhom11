package com.example.demoexe4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DSVideo extends AppCompatActivity {
    ListView lvVideo;
    ArrayList<Video> mp3ArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsvideo);
        lvVideo = (ListView) findViewById(R.id.lvVideo);
        mp3ArrayList = new ArrayList<>();
        mp3ArrayList.add(new Video("Oggy và những chú gián",R.drawable.bacongian,"bacongian"));
        mp3ArrayList.add(new Video("KingKong Đại Chiến Khủng Long",R.drawable.kingkong,"khunglong"));
        mp3ArrayList.add(new Video("Cảm Ơn Vì Tất Cả",R.drawable.nhac,"nhac"));
                ListViewAdapter listviewAdapter = new ListViewAdapter(this,R.layout.activity_dsvideo,mp3ArrayList);
        lvVideo.setAdapter(listviewAdapter);
    }
}
