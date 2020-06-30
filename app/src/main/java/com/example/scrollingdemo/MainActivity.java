package com.example.scrollingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.scrollingdemo.constainlayout.ConstainLayoutActivity;
import com.example.scrollingdemo.moveimage.MoveImageActivity;
import com.example.scrollingdemo.sweapimage.SweapImageActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onScrolling(View view) {
        startActivity(new Intent(MainActivity.this, ScrollingActivity.class));
    }

    public void onSweapImage(View view) {
        startActivity(new Intent(MainActivity.this, SweapImageActivity.class));
    }

    public void onMoveImage(View view) {
        startActivity(new Intent(MainActivity.this, MoveImageActivity.class));
    }

    public void onConstainLayout(View view) {
        startActivity(new Intent(MainActivity.this, ConstainLayoutActivity.class));
    }
}