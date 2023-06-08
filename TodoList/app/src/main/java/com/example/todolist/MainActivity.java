package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private String userNo;

    ArrayList<String> toDoList;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText inputAddText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        // 초기화
        toDoList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.todo_list_item, toDoList);
        listView = findViewById(R.id.listView);
        inputAddText = findViewById(R.id.inputAddText);

        // 어댑터 적용
        listView.setAdapter(adapter);

        // 할일 추가 버튼 이벤트
        Button btnAddList = findViewById(R.id.btnAddList);
        btnAddList.setOnClickListener(this::addItemToList);

        // 리스트 아이템 클릭 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;

                // 취소선 넣기
                System.out.println(textView.getPaintFlags());

                if(textView.getPaintFlags() == 1283){
                    textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    textView.setPaintFlags(1283);
                }

            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        // 계정 고유 번호
        userNo = currentUser.getUid();
    }

    // 할일 추가
    private void addItemToList(View v){
        // 아이템 등록
        toDoList.add(inputAddText.getText().toString());

        // 적용
        adapter.notifyDataSetChanged();

        // 입력창 초기화
        inputAddText.setText("");
    }
}