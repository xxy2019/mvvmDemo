package com.xxy.mvvmdemo.data.http;

import com.xxy.mvvmdemo.data.http.service.DemoApiService;
import com.xxy.mvvmdemo.data.http.service.TestService;
import com.xxy.mvvmdemo.entity.DemoEntity;
import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.entity.BaseResponseEntity;
import me.goldze.mvvmhabit.http.utils.RetrofitClientUtils;

public class HttpDataSourceImpl implements HttpDataSource {
    private DemoApiService apiService;

    private TestService testService;

    private volatile static HttpDataSourceImpl INSTANCE = null;

    public static HttpDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private HttpDataSourceImpl() {
        //配置网络请求服务端地址
        RetrofitClientUtils.baseUrl = "http://91iottest.qevoc.com/";
        //网络API服务
        apiService = RetrofitClientUtils.getInstance().create(DemoApiService.class);
        testService = RetrofitClientUtils.getInstance().create(TestService.class);
    }

    @Override
    public Observable<BaseResponseEntity<DemoEntity>> demoGet() {
        return apiService.demoGet();
    }

    @Override
    public Observable<BaseResponseEntity<DemoEntity>> demoPost(String catalog) {
        return apiService.demoPost(catalog);
    }

    @Override
    public Observable<BaseResponseEntity<String>> testGet() {
        return testService.testGet();
    }
}
