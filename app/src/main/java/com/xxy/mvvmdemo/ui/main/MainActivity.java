package com.xxy.mvvmdemo.ui.main;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.xxy.mvvmdemo.BR;
import com.xxy.mvvmdemo.R;
import com.xxy.mvvmdemo.data.DemoRepository;
import com.xxy.mvvmdemo.data.Injection;
import com.xxy.mvvmdemo.databinding.ActivityMainBinding;
import me.goldze.mvvmhabit.base.activity.BaseActivity;
import me.goldze.mvvmhabit.base.data.ViewModelFactory;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public MainViewModel initViewModel() {
        ViewModelFactory<DemoRepository> factory = ViewModelFactory.getInstance(getApplication(), Injection.provideDemoRepository());
        return  new ViewModelProvider(this, factory).get(MainViewModel.class);
    }
}