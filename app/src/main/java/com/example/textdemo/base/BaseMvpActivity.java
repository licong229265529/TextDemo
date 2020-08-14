package com.example.textdemo.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V, P>  {

    private View baseView;
    private Unbinder bind;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ActivityManager.getActivityManager().addActivity(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//禁止横屏
        bind = ButterKnife.bind(this);
        initView();
    }

    protected abstract int getLayout();

    /**
     * 让acticity去除状态栏
     */
    protected void setAllWindows() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    protected void initView() {
        addListener();
        processLogic();
    }

    /**
     * 添加监听
     */
    protected abstract void addListener();

    /**
     * 处理事务
     */
    protected abstract void processLogic();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getActivityManager().finishActivity(this);
        if (bind!=null){
            bind.unbind();
        }

    }

    public void onResume() {
        super.onResume();

    }

    public void onPause() {
        super.onPause();

    }


}
