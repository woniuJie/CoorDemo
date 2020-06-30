package com.example.scrollingdemo.sweapimage;

import com.example.scrollingdemo.MyApplication;

/**
 * Created by zhangshijie on 2020/6/26
 * Describe:
 */
public class CommonUtils {

    /**
     * 获取dimens定义的大小
     *
     * @param dimensionId
     * @return
     */
    public static int getPixelById(int dimensionId) {
        return MyApplication.getmContext().getResources().getDimensionPixelSize(dimensionId);
    }
}
