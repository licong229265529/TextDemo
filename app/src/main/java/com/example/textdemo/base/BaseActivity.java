package com.example.textdemo.base;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.view.View;

import androidx.fragment.app.FragmentActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends FragmentActivity {


    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decorView=getWindow().getDecorView();
            int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(getLayout());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActivityManager.getActivityManager().addActivity(this);
        bind = ButterKnife.bind(this);
        initView();
    }
    private void initView() {
        addListener();
        processLogic();
    }
    //获取布局文件
    protected abstract int getLayout();
    /**
     * 添加监听
     */
    protected abstract void addListener();

    /**
     * 处理事务
     */
    protected abstract void processLogic();



    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bind != null){
            bind.unbind();
        }
        ActivityManager.getActivityManager().finishActivity(this);
    }

}