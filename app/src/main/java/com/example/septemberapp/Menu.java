package com.example.septemberapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Menu extends ListActivity {

    String classes[] ={"MainScreen","TextPlay","Email",
                        "Camera","Data","Example5","Example6","Example7"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1,classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String choice = classes[position];
        try {
            Class ourClass = Class.forName("com.example.septemberapp."+ choice);
            Intent ourIntent = new Intent(Menu.this,ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Intent ourIntent = new Intent(Menu.this,classes[position].getClass());

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.aboutUs:

                break;
            case R.id.preferences:

                break;

        }
        return false;
    }


}
