package com.example.textdemo.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import rx.Subscription;


public class BasePresenter<V extends MvpView> extends MvpBasePresenter<V> {

    public V mvpView;

    protected int isRefresh;

    protected Subscription subscription;

    public void destory() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
