package com.xxy.mvvmdemo.ui.splash;

import androidx.lifecycle.ViewModelProvider;
import com.xxy.mvvmdemo.R;
import com.xxy.mvvmdemo.data.DemoRepository;
import com.xxy.mvvmdemo.data.Injection;
import me.goldze.mvvmhabit.base.activity.BaseSplashActivity;
import me.goldze.mvvmhabit.base.data.ViewModelFactory;

/**
 * 启动页【无需适配屏幕大小】
 */
public class SplashActivity extends BaseSplashActivity<SplashViewModel> {

    @Override
    protected long getSplashDurationMillis() {
        return 500;
    }

    /**
     * activity启动后的初始化
     */
    @Override
    protected void onCreateActivity() {
        initSplashView(R.mipmap.image_splash);
        startSplash(false);
    }

    @Override
    public SplashViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        ViewModelFactory<DemoRepository> factory = ViewModelFactory.getInstance(getApplication(), Injection.provideDemoRepository());
        return new ViewModelProvider(this, factory).get(SplashViewModel.class);
    }

    /**
     * 启动页结束后的动作
     */
    @Override
    protected void onSplashFinished() {
        viewModel.onSplashFinished();
    }
}
