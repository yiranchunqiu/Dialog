package com.pxz.pxzdialog.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pxz.pxzdialog.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/**
 * 类说明：BaseDialogFragment
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/9/17 15:22
 */
public abstract class BaseDialogFragment extends DialogFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题，设置样式
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.CustomDialog);
        //获取数据
        initGetData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //dialog弹出后会点击屏幕，dialog不消失；点击物理返回键dialog消失
        getDialog().setCanceledOnTouchOutside(getCanceledOnTouchOutside());
        //布局
        View mRootView = inflater.inflate(getLayoutId(), container, false);
        //初始化控件
        initFindById(mRootView);
        //数据初始化
        initData();
        //点击事件
        initListener();
        return mRootView;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            //在每个add事务前增加一个remove事务，防止连续的add
            manager.beginTransaction().remove(this).commit();
            super.show(manager, tag);
        } catch (Exception e) {
            //同一实例使用不同的tag会异常,这里捕获一下
            e.printStackTrace();
        }
    }

    /**
     * 获取数据
     */
    protected abstract void initGetData();

    /**
     * 点击屏幕消不消失
     *
     * @return 是否
     */
    protected abstract boolean getCanceledOnTouchOutside();

    /**
     * 布局
     *
     * @return 布局
     */
    protected abstract int getLayoutId();

    /**
     * 初始化控件
     *
     * @param mRootView view
     */
    protected abstract void initFindById(View mRootView);

    /**
     * 数据处理
     */
    protected abstract void initData();

    /**
     * 点击事件
     */
    protected abstract void initListener();
}