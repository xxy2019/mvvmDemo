package com.xxy.mvvmdemo.data.local;

import androidx.lifecycle.LiveData;

import com.xxy.mvvmdemo.data.local.base.Constant;
import com.xxy.mvvmdemo.data.local.base.DbHelper;
import com.xxy.mvvmdemo.data.local.dao.TestDao;
import com.xxy.mvvmdemo.data.local.entity.TestEntity;

import java.util.List;

import me.goldze.mvvmhabit.utils.SPUtils;
import me.goldze.mvvmhabit.utils.Utils;

/**
 * 本地数据源，可配合Room框架使用
 */
public class LocalDataSourceImpl implements LocalDataSource {
    private volatile static LocalDataSourceImpl INSTANCE = null;
    //数据表
    private TestDao testDao;

    public static LocalDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void initDatabase() {
        //数据库Helper构建
        DbHelper.getInstance(Utils.getContext()).initDb(getUserName());
        testDao = DbHelper.getInstance(Utils.getContext()).getTestDao();
    }

    @Override
    public void closeDatabase() {
        DbHelper.getInstance(Utils.getContext()).closeDb();
    }

    @Override
    public void saveUserName(String userName) {
        SPUtils.getInstance().put(Constant.USERNAME, userName);
    }

    @Override
    public String getUserName() {
        return SPUtils.getInstance().getString(Constant.USERNAME);
    }

    @Override
    public void savePassword(String password) {
        SPUtils.getInstance().put(Constant.PASSWORD, password);
    }

    @Override
    public String getPassword() {
        return SPUtils.getInstance().getString(Constant.PASSWORD);
    }

    @Override
    public LiveData<List<TestEntity>> loadAll() {
        return testDao.loadAll();
    }
}
