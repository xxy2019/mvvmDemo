package com.xxy.mvvmdemo.data.local.dao;

import androidx.room.Dao;
import androidx.room.Query;
import com.xxy.mvvmdemo.data.local.entity.TestEntity;
import java.util.List;
import me.goldze.mvvmhabit.local.BaseDao;

@Dao
public interface TestDao extends BaseDao<TestEntity> {

    @Query("select * from test")
    List<TestEntity> loadAll();
}
