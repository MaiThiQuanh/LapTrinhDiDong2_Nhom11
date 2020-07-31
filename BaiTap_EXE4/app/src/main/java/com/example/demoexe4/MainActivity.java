package com.example.demoexe4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    ImageView imgMp3,imgVideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgMp3 = (ImageView) findViewById(R.id.imgMp3);
        imgVideo = (ImageView) findViewById(R.id.imgYoutube);


        imgMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SoundPool.class);
                startActivity(intent);
            }
        });
        imgVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DSVideo.class);
                startActivity(intent);

            }
        });

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.xoay);
        imgMp3.setAnimation(animation);

        Animation animationvideo = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom);
        imgVideo.setAnimation(animationvideo);

    }

}

