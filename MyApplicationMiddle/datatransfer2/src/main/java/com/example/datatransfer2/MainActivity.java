package com.example.datatransfer2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private ActivityResultLauncher<Intent> launcher;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button button = (Button) findViewById(R.id.button);

        // 런처 등록 및 콜백 함수 등록
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
        /*        new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if (o.getResultCode() == RESULT_OK) {
                            Intent data = o.getData();
                            if (data != null) {
                                String resultData = data.getStringExtra("subMsg");
                                editText.setText(resultData);
                            }
                        }
                    }
                }); */
                o -> {
                    if(o.getResultCode() == RESULT_OK) {
                        Intent data = o.getData();
                        if(data != null) {
                            String resultText = data.getStringExtra("SubMsg");
                            editText.setText(resultText);
                        }
                    }
                });

        // 버튼 클릭 시 실행: SubMain에 데이터 전달과 화면 생성 launcher를 사용
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                String msg = editText.getText().toString();
                intent.putExtra("MainMsg", msg);
                //intent.putExtra("MainMsg", editText.getText().toString());
                launcher.launch(intent); //
                //startActivity(intent);
            }
        });
    }
}