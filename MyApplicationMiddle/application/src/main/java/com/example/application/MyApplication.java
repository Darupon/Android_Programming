package com.example.application;

import android.app.Application;

public class MyApplication extends Application{
    private String globalString;

    @Override
    public void onCreate() {
        super.onCreate();
        globalString = "Hello MainActivity";
    }
    public String getGlobalString() {
        return globalString;
    }
    public void setGlobalString(String globalString) {
        this.globalString = globalString;
    }
}
