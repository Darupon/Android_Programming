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

public class MainActivity extends AppCompatActivity {
    /* 멤버변수는 속성을 나타내는데 기본적으로 외부의 접근을 차단하기 위해 private 접근제한자를 사용한다 */
    private TextView textView;
    private EditText editText;
    private Button button;
    /* 멤버함수는 외부에서 접근을 위하여 public 접근제한자를 사용한다. */
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {    // 화면 생성 이벤트
        super.onCreate(savedInstanceState);     // 부모 생성자 호출
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // 메인 화면을 표시
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                editText.setText("");
                textView.setText(str);
            }
        });

    }
}