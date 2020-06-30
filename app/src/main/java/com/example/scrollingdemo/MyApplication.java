package com.example.scrollingdemo;

import android.app.Application;
import android.content.Context;

import com.github.moduth.blockcanary.BlockCanary;

/**
 * Created by zhangshijie on 2020/6/23
 * Describe:
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
    }

    public static Context getmContext() {
        return mContext;
    }
}
