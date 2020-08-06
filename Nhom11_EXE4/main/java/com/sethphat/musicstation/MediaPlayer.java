package com.sethphat.musicstation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MediaPlayer extends AppCompatActivity {
    private VideoView videoView;
    private MediaController mediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        videoView = (VideoView) findViewById(R.id.video);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BH");
        String tenBH = bundle.getString("TENBH");

        if(mediaController == null){
            mediaController = new MediaController(MediaPlayer.this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
        }
        try {
            // ID của file video.
            int id = this.getRawResIdByName(tenBH);
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
    }
    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
}
