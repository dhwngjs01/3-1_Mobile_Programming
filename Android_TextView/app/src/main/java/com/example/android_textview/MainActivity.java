package com.example.android_textview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        TextView objTV = new TextView(this);
        objTV.setText("Android Programming !");
        objTV.setGravity(0x11);
        objTV.setTextColor(Color.BLUE);
        objTV.setTextSize(0x20);
        setContentView(objTV);
    }
}