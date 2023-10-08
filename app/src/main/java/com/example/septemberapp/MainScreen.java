package com.example.septemberapp;

import static com.example.septemberapp.R.menu.main_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.aboutUs:
                //Intent i = new Intent("com.example.septemberapp.ABOUT");
                Intent i = new Intent("com.example.septemberapp.ABOUTUS");
                startActivity(i);
                break;
            case R.id.preferences:
                Intent p = new Intent("com.example.septemberapp.PREFS");
                startActivity(p);
                break;
            case R.id.exit:
                finish();
                break;

        }
        return false;
    }




}