package com.xxy.mvvmdemo.ui.test;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.xxy.mvvmdemo.BR;
import com.xxy.mvvmdemo.R;
import com.xxy.mvvmdemo.data.DemoRepository;
import com.xxy.mvvmdemo.data.Injection;
import com.xxy.mvvmdemo.databinding.ActivityTestBinding;
import me.goldze.mvvmhabit.base.activity.BaseActivity;
import me.goldze.mvvmhabit.base.data.ViewModelFactory;

public class TestActivity extends BaseActivity<ActivityTestBinding, TestViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_test;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public TestViewModel initViewModel() {
        ViewModelFactory<DemoRepository> factory = ViewModelFactory.getInstance(getApplication(), Injection.provideDemoRepository());
        return new ViewModelProvider(this, factory).get(TestViewModel.class);
    }

    @Override
    public void initViewObservable() {
        //当数据表变化时可以监听到
        viewModel.data.observe(this, testEntities -> {

        });
    }
}