package com.example.scrollingdemo.sweapimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.scrollingdemo.R;

import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class SweapImageActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sweap_image);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiImageSelector.create()
                        .showCamera(true) // show camera or not. true by default
                        .count(9) // max select image size, 9 by default. used width #.multi()
                        .multi() // multi mode, default mode;
                        .start(SweapImageActivity.this, REQUEST_IMAGE);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK) {//文章图片
            PostImagesActivity.startPostActivity(SweapImageActivity.this,
                    data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT));
        }
    }
}