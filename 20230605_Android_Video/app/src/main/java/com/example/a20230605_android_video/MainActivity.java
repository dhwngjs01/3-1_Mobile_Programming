package com.example.a20230605_android_video;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView objVideo;
    MediaController mediaCTRL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objVideo = (VideoView) findViewById(R.id.videoView);
        mediaCTRL = new MediaController(this);

        mediaCTRL.setAnchorView(objVideo);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/raw/video");

        objVideo.setMediaController(mediaCTRL);
        objVideo.setVideoURI(videoUri);
        objVideo.requestFocus();
        objVideo.start();
    }
}