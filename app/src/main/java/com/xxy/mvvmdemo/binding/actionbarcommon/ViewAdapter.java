package com.xxy.mvvmdemo.binding.actionbarcommon;

import androidx.databinding.BindingAdapter;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import per.goweii.actionbarex.common.ActionBarCommon;

public class ViewAdapter {
    /**
     * @param bindingCommand //绑定监听
     */
    @BindingAdapter(value = {"testTitle"}, requireAll = false)
    public static void setTestTitle(final ActionBarCommon titleBar, final BindingCommand<Boolean> bindingCommand) {
        titleBar.getTitleTextView().setOnClickListener(view ->
                bindingCommand.execute());
    }

    @BindingAdapter(value = {"testLeft"}, requireAll = false)
    public static void setTestLeft(final ActionBarCommon titleBar, final BindingCommand<Boolean> bindingCommand) {
        titleBar.setOnLeftTextClickListener(view ->
                bindingCommand.execute());
    }
}
