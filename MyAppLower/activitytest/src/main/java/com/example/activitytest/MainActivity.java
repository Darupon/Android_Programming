package com.example.activitytest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("test", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("test", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("test", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("test", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("test", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("test", "onResume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
            // Intent 클래스는 화면 전환을 위한 클래스
        });
    }
}