package com.example.textdemo.http;


import android.content.Context;

import com.example.textdemo.bean.HomeGoodsInfoNotJingXuan;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import rx.Subscription;


public class DataUtils {


/*
    public static Subscription getHomeGoods2(Context mContext, String typeId, String sort,
                                             int page, String level, ObserverProgress<JsonDataResponse<HomeGoodsInfoNotJingXuan>> observer) {
        return  NetWork.getInstance(mContext).getHomeGoodsApi()
                .getData(typeId, sort, page, level)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static Subscription getHomeGoods3(Context mContext, String typeId, String sort,
                                             int page, String level, ObserverProgress<JsonDataResponse<HomeGoodsInfoNotJingXuan>> observer) {
        return (Subscription) NetWork.getInstance(mContext).getHomeGoodsApi()
                .getData(typeId, sort, page, level)
              .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
*/


}
