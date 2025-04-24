package com.example.application2;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {
    private String id = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("test", "APP onCreate() called");
    }

    public void setId(String id) { // setter
        this.id = id;
    }

    public String getId() { // getter
        return id;
    }
}
