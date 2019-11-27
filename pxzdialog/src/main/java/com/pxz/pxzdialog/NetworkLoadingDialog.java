package com.pxz.pxzdialog;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pxz.pxzdialog.base.BaseDialogFragment;
import com.pxz.pxzdialog.bean.NetworkLoadingBean;

import androidx.core.content.ContextCompat;

/**
 * 类说明：网络加载dialog
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/27 12:56
 */
public class NetworkLoadingDialog extends BaseDialogFragment {
    private LinearLayout llDialog;
    private ProgressBar progressbar;
    private TextView tvDialogTitle;
    private NetworkLoadingBean networkLoadingBean=new NetworkLoadingBean();

    @Override
    protected void initGetData() {
        //获取数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            networkLoadingBean = bundle.getParcelable("networkLoadingBean");
        }
    }

    @Override
    protected boolean getCanceledOnTouchOutside() {
        return networkLoadingBean.isCanceledOnTouchOutside();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_network_loading;
    }

    @Override
    protected void initFindById(View mRootView) {
        llDialog=mRootView.findViewById(R.id.ll_dialog);
        progressbar=mRootView.findViewById(R.id.progressbar);
        tvDialogTitle=mRootView.findViewById(R.id.tv_dialog_title);
    }

    @Override
    protected void initData() {
        llDialog.setBackgroundResource(networkLoadingBean.getDialogStyle());
        Drawable drawable =ContextCompat.getDrawable(getActivity(),networkLoadingBean.getProgressbarStyle());
        progressbar.setIndeterminateDrawable(drawable);
        tvDialogTitle.setText(networkLoadingBean.getTitleText());
        tvDialogTitle.setTextColor(ContextCompat.getColor(getActivity(), networkLoadingBean.getTitleTextColor()));
    }

    @Override
    protected void initListener() {
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.gravity = Gravity.CENTER;
        window.setAttributes(attributes);
    }
}