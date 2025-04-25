package com.example.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView = (TextView) findViewById(R.id.textView);
        sqLiteHelper = new SQLiteHelper(this);

        sqLiteHelper.insertPerson("ABC efg", "011-0234-3424", "2025-04-25 13:20:54");
        sqLiteHelper.insertPerson("GHi sfd", "024-3432-2314", "2025-04-21 01:22:43");
        sqLiteHelper.insertPerson("BN sfd", "024-3432-2314", "2025-04-21 01:22:43");
        displayDate();
    }

    private void displayDate() {
        Cursor cursor = sqLiteHelper.getAllDate();
        if (cursor.getCount() == 0) {
            textView.setText("No data found.");
            return;
        }
        StringBuilder builder = new StringBuilder("Save DB: \n");
        while(cursor.moveToNext()) {
            builder.append("ID: ").append(cursor.getString(0)).append("\n");
            builder.append("Name: ").append(cursor.getString(1)).append("\n");
            builder.append("Phone: ").append(cursor.getString(2)).append("\n");
            builder.append("Time: ").append(cursor.getString(3)).append("\n");
        }
    }
}