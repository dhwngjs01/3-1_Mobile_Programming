package com.example.a20230522_android_dbsqlite3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase myDB;
    SimpleAdapter myADT;
    ArrayList<String> aryMBRList;
    ArrayAdapter<String> adtMembers;
    ListView lstView;
    String strRecord = null;
    ContentValues insertValue;
    Cursor allRCD;
    Button btnInsert, btnUpdate, btnDelete, btnSearch;
    EditText edtCarType, edtCarPower;
    String strSQL = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCarType = (EditText)findViewById(R.id.editCarType);
        edtCarPower = (EditText)findViewById(R.id.editCarPower);

        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(this);

        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);

        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);

        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);

        lstView = (ListView) findViewById(R.id.lstMember);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                myDB = this.openOrCreateDatabase("CarInformation", MODE_PRIVATE, null);
                myDB.execSQL("Drop table if exists Carlist");
            }
        });
    }

    @Override
    public void onClick(View v){

    }
}