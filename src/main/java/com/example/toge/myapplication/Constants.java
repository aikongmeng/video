package com.example.toge.myapplication;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by toge on 15/12/15.
 */
public class Constants {

    public static String[] strings = {
            "我想抬头看看天空",
            "看看他是什么模样",
            "神经质的线条",
            "让我感到面目扭曲",
            "血丝火红了双眼",
            "是什么让他如此痛苦?"

    };

    public static String[] urls = {
            "http://www.w3school.com.cn/example/html5/mov_bbb.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/example/html5/mov_bbb.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/example/html5/mov_bbb.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/example/html5/mov_bbb.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/example/html5/mov_bbb.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/example/html5/mov_bbb.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/example/html5/mov_bbb.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/example/html5/mov_bbb.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/example/html5/mov_bbb.mp4",
            "http://www.w3school.com.cn/i/movie.mp4",
            "http://www.w3school.com.cn/i/movie.mp4"

    };

    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        return width;
    }

    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }
}
