package com.example.datatransfer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub);

        // 전달된 인텐트를 복사해서 인텐트 객체 생성
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.TAG_MSG);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(msg);
    }
}