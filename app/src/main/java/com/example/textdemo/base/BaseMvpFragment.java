package com.example.textdemo.base;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.textdemo.utils.FragmentUserVisibleController;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpFragment<V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment<V, P>  implements  FragmentUserVisibleController.UserVisibleCallback {

    private View rootView;
    private Unbinder bind;
    private FragmentUserVisibleController userVisibleController;
    public BaseMvpFragment() {
        userVisibleController = new FragmentUserVisibleController(this, this);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userVisibleController.activityCreated();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getContentView(), null);
            bind = ButterKnife.bind(this, rootView);
        }

        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }



    @Override
    public void onResume() {
        super.onResume();
        userVisibleController.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        userVisibleController.pause();
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        userVisibleController.setUserVisibleHint(isVisibleToUser);
    }
    @Override
    public void setWaitingShowToUser(boolean waitingShowToUser) {
        userVisibleController.setWaitingShowToUser(waitingShowToUser);
    }

    @Override
    public boolean isWaitingShowToUser() {
        return userVisibleController.isWaitingShowToUser();
    }

    @Override
    public boolean isVisibleToUser() {
        return userVisibleController.isVisibleToUser();
    }

    @Override
    public void callSuperSetUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }
    private void initView() {
        findViews();
        addListener();
        tryProcessLogic();
    }
    /**
     * 加载布局文件
     *
     */
    public abstract int getContentView();
    /**
     * 寻找控件
     */
    protected abstract void findViews();


    /**
     * 添加监听
     */
    public abstract void addListener();

    /**
     * 处理数据
     */
    public abstract void processLogic();
    private boolean isFirst = true;
    private void tryProcessLogic(){
        if(isVisibleToUser()&&isFirst){
            processLogic();
            isFirst = false;
        }
    }

    @Override
    public void onVisibleToUserChanged(boolean isVisibleToUser, boolean invokeInResumeOrPause) {
        if(isVisibleToUser){
            tryProcessLogic();
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind!=null){
            bind.unbind();
        }
    }
}
