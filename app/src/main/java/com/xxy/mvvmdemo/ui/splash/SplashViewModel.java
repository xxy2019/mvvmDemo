package com.xxy.mvvmdemo.ui.splash;

import android.app.Application;
import androidx.annotation.NonNull;
import com.xxy.mvvmdemo.data.DemoRepository;
import com.xxy.mvvmdemo.ui.main.MainActivity;
import me.goldze.mvvmhabit.base.viewmodel.BaseViewModel;

public class SplashViewModel extends BaseViewModel<DemoRepository> {

    public SplashViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
    }

    /**
     * 启动页结束后的动作
     */
    public void onSplashFinished(){
        startActivity(MainActivity.class);
        finish();
    }
}
