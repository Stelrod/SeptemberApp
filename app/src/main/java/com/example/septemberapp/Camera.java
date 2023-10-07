package com.example.septemberapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;

public class Camera extends Activity implements View.OnClickListener {

    ImageView iv;
    ImageButton ib;
    Button b;
    Intent i;
    int cameraData = 0;
    Bitmap bmp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        Initialize();
        InputStream is = getResources().openRawResource(R.raw.splash);
        bmp = BitmapFactory.decodeStream(is);
    }

    private void Initialize() {
        iv = findViewById(R.id.ivReturnedPic);
        ib= findViewById(R.id.ibTakePic);
        b= findViewById(R.id.bSetWallpaper);
        b.setOnClickListener(this);
        ib.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSetWallpaper:
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ibTakePic:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, cameraData);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            iv.setImageBitmap(bmp);

        }
    }
}
