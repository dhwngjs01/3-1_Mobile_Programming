package com.example.a20230605_android_video2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView objVideo;
    String strVideoPath = "/sdcard/video.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objVideo = (VideoView) findViewById(R.id.videoView);

        objVideo.setVideoPath(strVideoPath);
        objVideo.start();
    }
}