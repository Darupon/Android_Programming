package com.example.button;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {   // 메인화면

    private TextView textView;  // TextView 타입 객체 textView 선언

    @Override // 상속관계에서 부모에 있는 메서드를 재정의
    protected void onCreate(Bundle savedInstanceState) {    // 화면생성 이벤트
        super.onCreate(savedInstanceState);                 // 부모생성자 호출, super는 부모랑 관련
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);             // 메인화면 표시
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        // xml의 위젯 TextView를 연결한다
        textView = (TextView) findViewById(R.id.textView);
        // xml의 위젯 button을 연결한다
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                textView.setText("Good bye");
            }
        });
// 콜백함수
        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                textView.setText("Good night");
            }
        });
    }
}