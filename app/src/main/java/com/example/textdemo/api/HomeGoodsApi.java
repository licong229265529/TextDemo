package com.example.textdemo.api;

import com.example.textdemo.bean.HomeGoodsInfoNotJingXuan;
import com.example.textdemo.http.JsonDataResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface HomeGoodsApi {

    @GET("item/{id}")
    Observable<JsonDataResponse<HomeGoodsInfoNotJingXuan>> getData(@Path("id") String id, @Query("sort") String sort, @Query("page") int page, @Query("level") String level);

}
