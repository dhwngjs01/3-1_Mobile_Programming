package com.example.a20230403_android_toggle_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ToggleButton objTButton = null; // ToggleButton Object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objTButton = (ToggleButton)findViewById(R.id.tglOnOff);
        objTButton.setOnClickListener(this);
    }

    public void onClick(View v){
        if(objTButton.isChecked()){
            Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_SHORT).show();
        }
    }
}