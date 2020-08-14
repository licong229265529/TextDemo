package com.example.textdemo.http;

import android.content.Context;

import com.example.textdemo.utils.Util;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestCacheInterceptor implements Interceptor {

    private Context context;

    public RequestCacheInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder(); //在原来的request的基础上修改
        if (!Util.isNetworkConnected(context)) {
            //无网下强制缓存
            builder.cacheControl(CacheControl.FORCE_CACHE); //等同于添加only-if-cache
        }
        Request newRequest = builder.build();
        return chain.proceed(newRequest);
    }
}
