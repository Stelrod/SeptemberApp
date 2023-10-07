package com.example.septemberapp;

import static com.example.septemberapp.R.menu.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

        MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.intro);
        mediaPlayer.start();
        Thread timer = new Thread(){
          public void run(){
              try {
                  sleep(5000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              } finally {
                  Intent intent = new Intent("com.example.septemberapp.MENU");
                  startActivity(intent);
              }
          }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
        finish();
    }


}