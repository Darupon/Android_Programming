package com.example.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // String str = "Error";
        MyApplication myApplication = (MyApplication) getApplication();
        String getString = myApplication.getGlobalString();

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(getString);
    }
}