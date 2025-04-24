package com.example.thread2;

import static java.lang.Thread.sleep;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.Semaphore;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private int counter = 0;
    private Semaphore semaphore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView textCount = (TextView) findViewById(R.id.textCount);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 키 획득
                    semaphore.acquire();
                    for (int i = 0; i < 100000; i++) {
                        counter++;
                    }
                    // 키 반납
                    semaphore.release();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                // 현재 스레드가 UI 스레드가 아님으로 메시지 Queue에 Runnable()을 등록한다.
                runOnUiThread(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        // 메시지 Queue에 등록될 메시지
                        textCount.setText("" + counter);
                    }
                });
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //semaphore.acquire();
                    for (int i = 100000; i > 0; i--) {
                        counter--;
                    }
                    //semaphore.release();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textCount.setText("" + counter);
                    }
                });
            }
        });
        thread2.start();
    }
}