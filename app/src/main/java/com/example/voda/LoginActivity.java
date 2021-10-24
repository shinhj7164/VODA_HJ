package com.example.voda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText emailBox;
    private EditText passwordBox;
    private Button regiBtn;
    private Button findPasswordBtn;
    private Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailBox = findViewById(R.id.et_email);
        passwordBox = findViewById(R.id.et_password);

        regiBtn = findViewById(R.id.btn_register);
        findPasswordBtn = findViewById(R.id.btn_findPassword);
        loginBtn = findViewById(R.id.btn_login);
        // 초기화

        //이부분에 파이어 베이스 로그인 부분 사장 계정으로 해야한다는 점


        //

        Intent intent = new Intent(getApplicationContext(), LocationActivity.class);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }
}