package com.xxy.mvvmdemo.data;

import com.xxy.mvvmdemo.data.http.HttpDataSource;
import com.xxy.mvvmdemo.data.http.HttpDataSourceImpl;
import com.xxy.mvvmdemo.data.local.LocalDataSource;
import com.xxy.mvvmdemo.data.local.LocalDataSourceImpl;

/**
 * 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构而架构）
 */
public class Injection {
    public static DemoRepository provideDemoRepository() {
        //网络数据源
        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance();
        //本地数据源
        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return DemoRepository.getInstance(httpDataSource, localDataSource);
    }
}
