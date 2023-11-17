package com.xxy.mvvmdemo.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;

import com.xxy.mvvmdemo.data.local.entity.TestEntity;
import com.xxy.mvvmdemo.entity.DemoEntity;
import com.xxy.mvvmdemo.data.http.HttpDataSource;
import com.xxy.mvvmdemo.data.local.LocalDataSource;

import java.util.List;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.data.BaseModel;
import me.goldze.mvvmhabit.http.entity.BaseResponseEntity;
import me.goldze.mvvmhabit.http.utils.RetrofitClientUtils;

/**
 * MVVM的Model层，模块统一的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repository）
 */
public class DemoRepository extends BaseModel implements HttpDataSource, LocalDataSource {
    private volatile static DemoRepository INSTANCE = null;
    private final HttpDataSource mHttpDataSource;

    private final LocalDataSource mLocalDataSource;

    private DemoRepository(@NonNull HttpDataSource httpDataSource,
                           @NonNull LocalDataSource localDataSource) {
        this.mHttpDataSource = httpDataSource;
        this.mLocalDataSource = localDataSource;
    }

    public static DemoRepository getInstance(HttpDataSource httpDataSource,
                                             LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (DemoRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DemoRepository(httpDataSource, localDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public Observable<BaseResponseEntity<DemoEntity>> demoGet() {
        return mHttpDataSource.demoGet();
    }

    @Override
    public Observable<BaseResponseEntity<DemoEntity>> demoPost(String catalog) {
        return mHttpDataSource.demoPost(catalog);
    }

    @Override
    public Observable<BaseResponseEntity<String>> testGet() {
        return mHttpDataSource.testGet();
    }

    @Override
    public void initDatabase() {
        mLocalDataSource.initDatabase();
    }

    @Override
    public void closeDatabase() {
        mLocalDataSource.closeDatabase();
    }

    @Override
    public void saveUserName(String userName) {
        mLocalDataSource.saveUserName(userName);
    }

    @Override
    public void savePassword(String password) {
        mLocalDataSource.savePassword(password);
    }

    @Override
    public String getUserName() {
        return mLocalDataSource.getUserName();
    }

    @Override
    public String getPassword() {
        return mLocalDataSource.getPassword();
    }

    @Override
    public LiveData<List<TestEntity>> loadAll() {
        return mLocalDataSource.loadAll();
    }
}
