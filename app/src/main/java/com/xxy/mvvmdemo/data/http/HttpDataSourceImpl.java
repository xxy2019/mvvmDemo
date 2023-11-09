package com.xxy.mvvmdemo.data.http;

import com.xxy.mvvmdemo.data.http.service.DemoApiService;
import com.xxy.mvvmdemo.entity.DemoEntity;
import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.entity.BaseResponseEntity;
import me.goldze.mvvmhabit.http.utils.RetrofitClientUtils;

public class HttpDataSourceImpl implements HttpDataSource {
    private DemoApiService apiService;
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
        //网络API服务
        apiService = RetrofitClientUtils.getInstance().create(DemoApiService.class);
    }

    @Override
    public Observable<BaseResponseEntity<DemoEntity>> demoGet() {
        return apiService.demoGet();
    }

    @Override
    public Observable<BaseResponseEntity<DemoEntity>> demoPost(String catalog) {
        return apiService.demoPost(catalog);
    }
}
