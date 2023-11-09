package com.xxy.mvvmdemo.binding.smartrefreshlayout;

import androidx.databinding.BindingAdapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * SmartRefreshLayout列表刷新的绑定适配器
 */
public class ViewAdapter {

    @BindingAdapter(value = {"onRefreshCommand"}, requireAll = false)
    public static void onRefreshCommand(SmartRefreshLayout layout, final BindingCommand onRefreshCommand) {
        layout.setOnRefreshListener(refreshLayout -> {
            if (onRefreshCommand != null) {
                onRefreshCommand.execute();
            }
        });
    }

    @BindingAdapter(value = {"onLoadMoreCommand"}, requireAll = false)
    public static void onLoadMoreCommand(SmartRefreshLayout layout, final BindingCommand onLoadMoreCommand) {
        layout.setOnLoadMoreListener(refreshLayout -> {
            if (onLoadMoreCommand != null) {
                onLoadMoreCommand.execute();
            }
        });
    }
}
