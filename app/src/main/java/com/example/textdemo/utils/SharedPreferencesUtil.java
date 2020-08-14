package com.example.textdemo.utils;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {
    //文件名
    public final static String PREF_FILE_NAME = "LOGIN";

        //获取存储数据
    public static String ReadSomeKey(Context context, String keyString) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
            String s = sharedPreferences.getString(keyString, "");
            return s;
        } catch (Exception e) {
            System.out.println("发生错误：" + e.getMessage());
            return null;
        }
    }

    //写入存储数据
    public static void WriteSomeKey(Context context, String key, String value) {
        try {
            SharedPreferences preferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(key, value);
            editor.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // 清除全部数据
    public static void ClearAll(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }
    // 清除单个数据key
    public static void ClearKey(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }

}
