package com.example.datatransfer2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity extends AppCompatActivity {

    private EditText editText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub);

        editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);

        // 수신
        Intent intent = getIntent();
        String msg = intent.getStringExtra("MainMsg");

        editText.setText(msg);

        // 버튼 동작. 송신
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();   // intent 객체 생성
                intent.putExtra("SubMsg", editText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}