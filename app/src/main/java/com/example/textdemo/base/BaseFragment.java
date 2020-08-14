package com.example.textdemo.base;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.textdemo.utils.FragmentUserVisibleController;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements  FragmentUserVisibleController.UserVisibleCallback {

    private View rootView;
    private FragmentUserVisibleController userVisibleController;
    private Unbinder bind;

    public BaseFragment() {
        userVisibleController = new FragmentUserVisibleController(this, this);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userVisibleController.activityCreated();

    }
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getContentView(), container, false);
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


    /**
     * 加载布局文件
     */
    public abstract int getContentView();
    /**
     * 寻找控件
     */
    public abstract void findViews();

    /**
     * 添加监听
     */
    public abstract void addListener();

    /**
     * 处理数据
     */
    public abstract void processLogic();

    @SuppressWarnings("unchecked")
    protected <T extends View> T findViewById(int resId) {
        return (T) rootView.findViewById(resId);
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
    public void onDestroyView() {
        super.onDestroyView();
        if (bind!=null){
            bind.unbind();
        }
    }
}
