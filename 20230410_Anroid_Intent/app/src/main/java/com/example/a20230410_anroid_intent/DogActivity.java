package com.example.a20230410_anroid_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DogActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOK;
    private EditText editSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v == btnOK){
            Intent CallIntent = getIntent();
            editSound = (EditText) findViewById(R.id.editInputSound);
            CallIntent.putExtra("Animal_Sound", editSound.getText().toString());
            setResult(RESULT_OK, CallIntent);
            finish();
        }
    }
}