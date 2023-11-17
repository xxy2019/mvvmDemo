package com.xxy.mvvmdemo.binding.actionbarcommon;

import androidx.databinding.BindingAdapter;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import per.goweii.actionbarex.common.ActionBarCommon;

public class ViewAdapter {

    @BindingAdapter(value = {"titleText"}, requireAll = false)
    public static void setTitleText(final ActionBarCommon titleBar, final String titleText) {
        titleBar.getTitleTextView().setText(titleText);
    }

    @BindingAdapter(value = {"titleOnClick"}, requireAll = false)
    public static void setTitleOnClickListener(final ActionBarCommon titleBar, final BindingCommand titleOnClickCommand) {
        titleBar.getTitleTextView().setOnClickListener(view ->
                titleOnClickCommand.execute());
    }
}
