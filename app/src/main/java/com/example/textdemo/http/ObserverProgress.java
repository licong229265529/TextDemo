package com.example.textdemo.http;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import rx.Observer;


public abstract class ObserverProgress<T> implements Observer<T> {

    private Context mContext;
    private String name,path,data;

    public ObserverProgress(String name) {
        this.name=name;
    }

    public void setContext (Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onCompleted() {
        completed();
    }

    @Override
    public void onError(Throwable e) {

        if (name!=null){
            Log.e("网络请求失败",e.toString()+name);

        }else{
            Log.e("网络请求失败",e.toString());
        }

        error(e);
    }
    protected abstract void completed();
    protected abstract void error(Throwable e);
    @Override
    public void onNext(T t) {
        if (path!=null){
            Log.e("请求参数","接口："+path);
            Log.e("请求参数","请求参数--:"+data);
        }

        if (t instanceof String){
            String json=(String) t;
            Log.e("返回数据",name+":"+json);
        }else{
            String s = new Gson().toJson(t);
            Log.e("返回数据",name+":"+s);
        }

    }
}