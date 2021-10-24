package com.example.voda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LocationActivity extends AppCompatActivity {

    private ImageView ivForHere;
    private ImageView ivToGo;
    private int location = 0; // 0은 매장 1은 포장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        ivForHere = findViewById(R.id.iv_forHere);
        ivToGo = findViewById(R.id.iv_toGo);

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);

        ivForHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = 0;
                startActivity(intent);
            }
        });


        ivToGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location = 1;
                startActivity(intent);
            }
        });


    }
}