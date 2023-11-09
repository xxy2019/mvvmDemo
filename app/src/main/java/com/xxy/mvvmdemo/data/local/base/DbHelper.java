package com.xxy.mvvmdemo.data.local.base;

import android.content.Context;
import android.util.Log;
import androidx.room.Room;
import com.blankj.utilcode.util.EncryptUtils;
import com.xxy.mvvmdemo.data.local.dao.TestDao;
import me.goldze.mvvmhabit.local.BaseDbHelper;

public class DbHelper extends BaseDbHelper<AppDatabase> {

    private static DbHelper instance;

    public DbHelper(Context context) {
        super(context);
    }

    public static DbHelper getInstance(Context context) {
        if(instance == null) {
            synchronized (BaseDbHelper.class) {
                if(instance == null) {
                    instance = new DbHelper(context);
                }
            }
        }
        return instance;
    }

    @Override
    protected AppDatabase initDatabase(String user) {
        String userMd5 = EncryptUtils.encryptMD5ToString(user).toLowerCase();
        // 以下数据库升级设置，为升级数据库将清掉之前的数据，如果要保留数据，慎重采用此种方式
        // 可以采用addMigrations()的方式，进行数据库的升级
        String dbName = String.format("em_%1$s.db", userMd5);
        Log.d(TAG, "db name = "+dbName);
        return Room.databaseBuilder(mContext, AppDatabase.class, dbName)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    /**
     * 初始化数据库
     */
    public TestDao getTestDao() {
        if(mDatabase != null) {
            return mDatabase.testDao();
        }
        return null;
    }
}
