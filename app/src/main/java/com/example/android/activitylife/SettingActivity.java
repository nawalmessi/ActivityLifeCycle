package com.example.android.activitylife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SettingActivity extends AppCompatActivity {
    private String tag = "Setting Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(tag,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(tag,"onReStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(tag,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(tag,"onStop");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e(tag,"onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(tag,"onDestroy");
    }
}

