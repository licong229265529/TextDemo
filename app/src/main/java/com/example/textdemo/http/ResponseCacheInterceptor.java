package com.example.textdemo.http;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Response;

public class ResponseCacheInterceptor  implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response = chain.proceed(chain.request()).newBuilder()
                .removeHeader("Pragma") //移除影响
                .removeHeader("Cache-Control") //移除影响
                .addHeader("Cache-Control", CacheControl.FORCE_CACHE.toString()).build();
        return response;
    }
}