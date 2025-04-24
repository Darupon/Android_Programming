package com.example.edittext;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    /* 멤버변수는 속성을 나타내는데 기본적으로 외부의 접근을 차단하기 위해 private 접근제한자를 사용한다 */
    private TextView textView;
    private EditText editText1;
    private Button  button1;
    private EditText editText2;
    private Button button2;
    /* 멤버함수는 외부에서 접근을 위하여 public 접근제한자를 사용한다. */
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {    // 화면 생성 이벤트
        super.onCreate(savedInstanceState);     // 부모 생성자 호출
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2); // 메인 화면을 표시
        textView = (TextView) findViewById(R.id.textView);
        editText1 = (EditText) findViewById(R.id.editText1);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText1.getText().toString();
                editText1.setText("");
                textView.setText("User1: " + str);
            }
        });

        editText2 = (EditText) findViewById(R.id.editText2);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText2.getText().toString();
                editText2.setText("");
                textView.setText("User2: " + str);
            }
        });

    }
}