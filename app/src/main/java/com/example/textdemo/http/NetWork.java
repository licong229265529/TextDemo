package com.example.textdemo.http;


import android.content.Context;

import com.example.textdemo.api.HomeGoodsApi;
import com.example.textdemo.utils.Constants;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//网络请求
public class NetWork {
    private static OkHttpClient okHttpClient;
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static RxJava2CallAdapterFactory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    private NetWork() {}
    private NetWork(Context mContext) {

        ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(mContext));
        //缓存文件夹
        File cacheFile = new File(mContext.getCacheDir(), "Cache");
        //缓存大小为10M
        int cacheSize = 8 * 100 * 1024 * 1024;
        //创建缓存对象
        Cache cache = new Cache(cacheFile, cacheSize);
        okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new RequestCacheInterceptor(mContext))
                .addNetworkInterceptor(new ResponseCacheInterceptor()) //在网络端添加响应拦截器（注意和用户端的区别）
                .cookieJar(cookieJar)
                .build();
    }
    public static NetWork getInstance(Context mContext) {
        NetWork newWork = new NetWork(mContext);
        return newWork;
    }

    private HomeGoodsApi homeGoodsApi;
    /**
     * 测试接口
     *
     * @return
     */
    public HomeGoodsApi getHomeGoodsApi() {
        if (homeGoodsApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constants.HTTPURL_SORT)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            homeGoodsApi = retrofit.create(HomeGoodsApi.class);
        }
        return homeGoodsApi;
    }


}
