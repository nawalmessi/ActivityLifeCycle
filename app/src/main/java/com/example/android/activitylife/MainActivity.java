package com.example.android.activitylife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private String tag = "Main Activity";
    MediaPlayer player;
    int position;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this, R.raw.despacito);
        position = player.getCurrentPosition();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                player.release();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        player.seekTo(position);
        player.start();
        Log.e(tag, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(tag, "onReStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(tag, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.pause();
        position = player.getCurrentPosition();

        Log.e(tag, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(tag, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(tag, "onDestroy");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        position = player.getCurrentPosition();
        editor.putInt("Song", position);
        editor.apply();
    }


    public void start(View view) {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }


}
