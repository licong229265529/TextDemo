package com.example.textdemo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import okhttp3.Request;

public class Util {

    private static Context context;

    public Util(Context context) {
        this.context = context;
    }

    //判断网络连接状态
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable();
    }

    //时间超时请求
    public static boolean isOutTime(Request builder) {
        builder.header("");
        return true;
    }


}
