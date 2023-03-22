package com.example.android_edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText objET = (EditText)findViewById(R.id.editText1);
        objET.setText("Google : ");
        objET.setGravity(0x01);

        String strData = objET.getText().toString();
        objET.setText(strData + " Anroid Programming.");
    }
}