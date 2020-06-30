package com.example.scrollingdemo.moveimage;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.scrollingdemo.R;

import java.util.List;

/**
 * Created by zhangshijie on 2020/6/26
 * Describe:
 */
public class SwapImageAdapter extends RecyclerView.Adapter<SwapImageAdapter.SwapViewHolder> {

    private Context mContext;
    private List<String> imagesList;

    public SwapImageAdapter(Context mContext, List<String> imagesList) {
        this.mContext = mContext;
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public SwapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_swap_image_layout, parent, false);
        return new SwapViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SwapViewHolder holder, int position) {
        Glide.with(mContext).load(imagesList.get(position)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    class SwapViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public SwapViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_move_image);
        }
    }

}
