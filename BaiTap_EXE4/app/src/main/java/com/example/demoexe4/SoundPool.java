package com.example.demoexe4;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SoundPool extends AppCompatActivity {
    RadioGroup radioGroup;
    private android.media.SoundPool soundPool;
    Button btnBack;

    private AudioManager audioManager;

    // Số luồng âm thanh phát ra tối đa.
    private static final int MAX_STREAMS = 5;

    // Chọn loại luồng âm thanh để phát nhạc.
    private static final int streamType = AudioManager.STREAM_MUSIC;

    private boolean loaded;

    private int destroy;
    private int dunn;
    private int evil;
    private int fall;
    private int gun;
    private int ill;
    private int music;
    private int sad;

    private float volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pool);
        radioGroup = (RadioGroup)  findViewById(R.id.radGroup);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoundPool.this,MainActivity.class);
                startActivity(intent);
            }
        });
        // Đối tượng AudioManager sử dụng để điều chỉnh âm lượng.
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Chỉ số âm lượng hiện tại của loại luồng nhạc cụ thể (streamType).
        float currentVolumeIndex = (float) audioManager.getStreamVolume(streamType);


        // Chỉ số âm lượng tối đa của loại luồng nhạc cụ thể (streamType).
        float maxVolumeIndex  = (float) audioManager.getStreamMaxVolume(streamType);

        // Âm lượng  (0 --> 1)
        this.volume = currentVolumeIndex / maxVolumeIndex;

        // Cho phép thay đổi âm lượng các luồng kiểu 'streamType' bằng các nút
        // điều khiển của phần cứng.
        this.setVolumeControlStream(streamType);

        // Với phiên bản Android SDK >= 21
        if (Build.VERSION.SDK_INT >= 21 ) {

            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            android.media.SoundPool.Builder builder= new android.media.SoundPool.Builder();
            builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);

            this.soundPool = builder.build();
        }
        // Với phiên bản Android SDK < 21
        else {
            // SoundPool(int maxStreams, int streamType, int srcQuality)
            this.soundPool = new android.media.SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        }

        // Sự kiện SoundPool đã tải lên bộ nhớ thành công.
        this.soundPool.setOnLoadCompleteListener(new android.media.SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(android.media.SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });
        // Tải file nhạc tiếng vật thể bị phá hủy (destroy.war) vào SoundPool.
        this.destroy = this.soundPool.load(this, R.raw.destroy,1);
        this.dunn = this.soundPool.load(this, R.raw.dunn,1);
        this.evil = this.soundPool.load(this, R.raw.evil,1);
        this.fall = this.soundPool.load(this, R.raw.fall,1);
        this.gun = this.soundPool.load(this, R.raw.gun,1);
        this.ill = this.soundPool.load(this, R.raw.ill,1);
        this.music = this.soundPool.load(this, R.raw.music,1);
        this.sad = this.soundPool.load(this, R.raw.sad,1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rad1:
                        Toast.makeText(SoundPool.this,"Destroy",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad2:
                        Toast.makeText(SoundPool.this,"Dunn",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad3:
                        Toast.makeText(SoundPool.this,"Evil",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad4:
                        Toast.makeText(SoundPool.this,"Fall",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad5:
                        Toast.makeText(SoundPool.this,"Gun",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad6:
                        Toast.makeText(SoundPool.this,"Ill",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad7:
                        Toast.makeText(SoundPool.this,"Music",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad8:
                        Toast.makeText(SoundPool.this,"Sad",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.rad1:
                if(loaded){
                    float leftVolumn = volume;
                    float rightVolumn = volume;
                    int streamId = this.soundPool.play(this.destroy,leftVolumn, rightVolumn, 1, 0, 1f);
                }
                break;
            case R.id.rad2:
                if(loaded){
                    float leftVolumn = volume;
                    float rightVolumn = volume;
                    int streamId = this.soundPool.play(this.dunn,leftVolumn, rightVolumn, 1, 0, 1f);
                }
                break;
            case R.id.rad3:
                if(loaded){
                    float leftVolumn = volume;
                    float rightVolumn = volume;
                    int streamId = this.soundPool.play(this.evil,leftVolumn, rightVolumn, 1, 0, 1f);
                }
                break;
            case R.id.rad4:
                if(loaded){
                    float leftVolumn = volume;
                    float rightVolumn = volume;
                    int streamId = this.soundPool.play(this.fall,leftVolumn, rightVolumn, 1, 0, 1f);
                }
                break;
            case R.id.rad5:
                if(loaded){
                    float leftVolumn = volume;
                    float rightVolumn = volume;
                    int streamId = this.soundPool.play(this.gun,leftVolumn, rightVolumn, 1, 0, 1f);
                }
                break;
            case R.id.rad6:
                if(loaded){
                    float leftVolumn = volume;
                    float rightVolumn = volume;
                    int streamId = this.soundPool.play(this.ill,leftVolumn, rightVolumn, 1, 0, 1f);
                }
                break;
            case R.id.rad7:
                if(loaded){
                    float leftVolumn = volume;
                    float rightVolumn = volume;
                    int streamId = this.soundPool.play(this.music,leftVolumn, rightVolumn, 1, 0, 1f);
                }
                break;
            case R.id.rad8:
                if(loaded){
                    float leftVolumn = volume;
                    float rightVolumn = volume;
                    int streamId = this.soundPool.play(this.sad,leftVolumn, rightVolumn, 1, 0, 1f);
                }
                break;
        }
    }
}
