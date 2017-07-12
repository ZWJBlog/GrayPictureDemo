package com.example.msi.graypicturedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Bitmap bitmaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.img);
        bitmaps = BitmapFactory.decodeResource(getResources(), R.mipmap.sudu);

//        new GrayPicture().setBitmap(bitmaps, 1, 1, 1)
        img.setImageBitmap(new GrayPicture().setBitmap(bitmaps));
    }
}
