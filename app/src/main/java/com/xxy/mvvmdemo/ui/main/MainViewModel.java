package com.xxy.mvvmdemo.ui.main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.xuexiang.xupdate.XUpdate;
import com.xxy.mlkitscanner.MNScanManager;
import com.xxy.mlkitscanner.callback.act.MNScanCallback;
import com.xxy.mvvmdemo.data.DemoRepository;
import java.util.ArrayList;
import me.goldze.mvvmhabit.base.viewmodel.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.goldze.mvvmhabit.utils.lifecycleManager.AppManager;

public class MainViewModel extends BaseViewModel<DemoRepository> {

    public MainViewModel(@NonNull Application application, DemoRepository model) {
        super(application, model);
    }

    @SuppressLint("CheckResult")
    public BindingCommand testClickCommand = new BindingCommand(() -> {
        //请求打开相机权限
        RxPermissions rxPermissions = new RxPermissions((FragmentActivity) AppManager.getAppManager().currentActivity());
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(aBoolean -> {
            if (aBoolean) {
                ToastUtils.showShort("权限已经打开");
            } else {
                ToastUtils.showShort("权限被拒绝");
            }
        });
    });

    public BindingCommand testClickCommand1 = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            XUpdate.newBuild(getApplication())
                    .updateUrl("https://gitee.com/xuexiangjys/XUpdate/raw/master/jsonapi/update_test.json")
                    .update();
        }
    });

    public BindingCommand testClickCommand2 = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //默认扫描
            MNScanManager.startScan(AppManager.getAppManager().currentActivity(), new MNScanCallback() {
                @Override
                public void onActivityResult(int resultCode, Intent data) {
                    switch (resultCode) {
                        case MNScanManager.RESULT_SUCCESS:
                            ArrayList<String> results = data.getStringArrayListExtra(MNScanManager.INTENT_KEY_RESULT_SUCCESS);
                            break;
                        case MNScanManager.RESULT_FAIL:
                            String resultError = data.getStringExtra(MNScanManager.INTENT_KEY_RESULT_ERROR);
                            break;
                        case MNScanManager.RESULT_CANCLE:
                            ToastUtils.showShort("取消扫码");
                            break;
                    }
                }
            });
        }
    });
}
