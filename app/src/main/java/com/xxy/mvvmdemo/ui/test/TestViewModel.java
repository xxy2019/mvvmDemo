package com.xxy.mvvmdemo.ui.test;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import com.xxy.mvvmdemo.data.DemoRepository;
import com.xxy.mvvmdemo.data.local.entity.TestEntity;
import java.util.List;
import me.goldze.mvvmhabit.base.viewmodel.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class TestViewModel extends BaseViewModel<DemoRepository> {

    public LiveData<List<TestEntity>> data;

    public ObservableField<String> titleStr = new ObservableField<>("标题");

    public TestViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
        model.initDatabase();//初始化操作最好在登录的时候处理
        data = model.loadAll();
    }

    public BindingCommand titleOnClickEvent = new BindingCommand(() -> {
        ToastUtils.showShort(titleStr.get());
    });
}
