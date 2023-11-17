package com.xxy.mvvmdemo.data.local;

import androidx.lifecycle.LiveData;

import com.xxy.mvvmdemo.data.local.entity.TestEntity;

import java.util.List;

public interface LocalDataSource {

    /**
     * 创建数据库
     */
    void initDatabase();

    /**
     * 关闭数据库
     */
    void closeDatabase();
    /**
     * 保存用户名
     */
    void saveUserName(String userName);

    /**
     * 获取用户名
     */
    String getUserName();

    /**
     * 保存用户密码
     */

    void savePassword(String password);

    /**
     * 获取用户密码
     */
    String getPassword();

    /**
     * 获取表中所有数据
     */
    LiveData<List<TestEntity>> loadAll();
}
