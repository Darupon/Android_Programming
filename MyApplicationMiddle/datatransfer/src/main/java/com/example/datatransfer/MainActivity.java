package com.example.datatransfer;

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

public class MainActivity extends AppCompatActivity {
    public static String TAG_MSG = "message";
    private EditText editText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 전송을 위햔 Intent 객체 생성
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                // editText의 입력값을 일어와서 문자열로 변환 후 msg 객체에 저장
                String msg = editText.getText().toString();
                // 화면 clear
                editText.setText("");

                // 전송. putExtra(key, value);
                intent.putExtra(TAG_MSG, msg);
                // 새로운 액티비티를 호출하는데 intent 객체를 인자로 전달한다.
                startActivity(intent);
            }
        });

    }
}