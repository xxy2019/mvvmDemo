package com.xxy.mvvmdemo.data.http;

import com.xxy.mvvmdemo.entity.DemoEntity;
import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.entity.BaseResponseEntity;

public interface HttpDataSource {

    Observable<BaseResponseEntity<DemoEntity>> demoGet();

    Observable<BaseResponseEntity<DemoEntity>> demoPost(String catalog);

    Observable<BaseResponseEntity<String>> testGet();

}
