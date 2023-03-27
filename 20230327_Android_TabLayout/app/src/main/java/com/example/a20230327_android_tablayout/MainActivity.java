package com.example.a20230327_android_tablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TabHost;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabHost myTabHost = null;
    TabHost.TabSpec myTabSpec;
    Drawable imgIcon = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTabHost = (TabHost)findViewById(R.id.tabhost);
        myTabHost.setup();

        // Add Tab
        myTabSpec = myTabHost.newTabSpec("Artists")
                .setIndicator("Artists") // Tab Subject
                .setContent(R.id.tab1); // Tab Content
        myTabHost.addTab(myTabSpec);

        myTabSpec = myTabHost.newTabSpec("Albums")
                .setIndicator("Albums") // Tab Subject
                .setContent(R.id.tab2); // Tab Content
        myTabHost.addTab(myTabSpec);

        myTabSpec = myTabHost.newTabSpec("Songs")
                .setIndicator("Songs") // Tab Subject
                .setContent(R.id.tab3); // Tab Content
        myTabHost.addTab(myTabSpec);

        myTabHost.setCurrentTab(0); // Setting First Tab


        // String Array - Color
        String[] color = {"#FF0000", "#00FF00", "#0000FF"};

        // Change Tab Background Color And Set Tab Height = 150
        for(int i = 0; i < myTabHost.getTabWidget().getChildCount(); i++){
            myTabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor(color[i]));
            myTabHost.getTabWidget().getChildAt(i).getLayoutParams().height = 150;
        }
    }
}