package com.xxy.mvvmdemo.data.http.service;

import com.xxy.mvvmdemo.entity.DemoEntity;
import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.entity.BaseResponseEntity;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DemoApiService {
    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponseEntity<DemoEntity>> demoGet();

    @FormUrlEncoded
    @POST("action/apiv2/banner")
    Observable<BaseResponseEntity<DemoEntity>> demoPost(@Field("catalog") String catalog);
}
