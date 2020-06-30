package com.example.scrollingdemo.moveimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.scrollingdemo.R;
import com.example.scrollingdemo.sweapimage.MyCallBack;
import com.hys.utils.AppUtils;
import com.hys.utils.InitCacheFileUtils;

import java.util.ArrayList;
import java.util.List;

import static com.example.scrollingdemo.sweapimage.PostImagesActivity.FILE_DIR_NAME;
import static com.example.scrollingdemo.sweapimage.PostImagesActivity.FILE_IMG_NAME;

public class MoveImageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwapImageAdapter adapter;
    private List<String> dragImages = new ArrayList<>();
    private List<String> originImages = new ArrayList<>();
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_image);
        recyclerView = findViewById(R.id.recycler_move_image);

        dragImages.add("https://m.360buyimg.com/mobilecms/s120x120_jfs/t1/85541/12/16732/5068/5e7d60f9E0ff389b4/de3b049134031e56.png.webp");
        dragImages.add("https://m.360buyimg.com/mobilecms/s120x120_jfs/t1/85541/12/16732/5068/5e7d60f9E0ff389b4/de3b049134031e56.png.webp");
        dragImages.add("https://m.360buyimg.com/mobilecms/s120x120_jfs/t1/85541/12/16732/5068/5e7d60f9E0ff389b4/de3b049134031e56.png.webp");
        dragImages.add("https://m.360buyimg.com/mobilecms/s120x120_jfs/t1/85541/12/16732/5068/5e7d60f9E0ff389b4/de3b049134031e56.png.webp");
        dragImages.add("https://m.360buyimg.com/mobilecms/s120x120_jfs/t1/85541/12/16732/5068/5e7d60f9E0ff389b4/de3b049134031e56.png.webp");
        dragImages.add("https://m.360buyimg.com/mobilecms/s120x120_jfs/t1/85541/12/16732/5068/5e7d60f9E0ff389b4/de3b049134031e56.png.webp");
        dragImages.add("https://m.360buyimg.com/mobilecms/s120x120_jfs/t1/85541/12/16732/5068/5e7d60f9E0ff389b4/de3b049134031e56.png.webp");
        dragImages.add("https://m.360buyimg.com/mobilecms/s120x120_jfs/t1/96727/8/16477/5183/5e7d6249E4730c38a/0f70da903eded263.png.webp");
        dragImages.add("https://m.360buyimg.com/mobilecms/s120x120_jfs/t1/96542/9/16707/3569/5e7d62bcE5c4ee6a7/3bf6ac36ac9f17d9.png.webp");
        String plusPath = getString(R.string.glide_plus_icon_string) + AppUtils.getPackageInfo(this).packageName + "/mipmap/" + R.mipmap.mine_btn_plus;

        dragImages.add(plusPath);

        adapter = new SwapImageAdapter(this, dragImages);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        MyItemCallback myCallBack = new MyItemCallback(adapter, dragImages);
        itemTouchHelper = new ItemTouchHelper(myCallBack);
        itemTouchHelper.attachToRecyclerView(recyclerView);//绑定RecyclerView

        recyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(recyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {

            }

            @Override
            public void onItemLongClick(RecyclerView.ViewHolder vh) {
                //如果item不是最后一个，则执行拖拽
                if (vh.getLayoutPosition() != dragImages.size() - 1) {
                    itemTouchHelper.startDrag(vh);
                }
            }
        });


    }
}