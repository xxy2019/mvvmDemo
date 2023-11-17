package com.xxy.mvvmdemo.data.http.service;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.entity.BaseResponseEntity;
import retrofit2.http.GET;

public interface TestService {

    @GET("url")
    Observable<BaseResponseEntity<String>> testGet();

}
