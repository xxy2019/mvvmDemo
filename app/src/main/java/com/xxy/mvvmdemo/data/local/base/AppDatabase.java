package com.xxy.mvvmdemo.data.local.base;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.xxy.mvvmdemo.data.local.dao.TestDao;
import com.xxy.mvvmdemo.data.local.entity.TestEntity;

@Database(entities = {TestEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TestDao testDao();
}
