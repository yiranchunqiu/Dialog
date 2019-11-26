package com.pxz.pxzdialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pxz.pxzdialog.base.BaseDialogFragment;
import com.pxz.pxzdialog.bean.BtnOneTitleBean;

import androidx.core.content.ContextCompat;

/**
 * 类说明：带标题的一个按钮的dialog
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/26 10:55
 */
public class BtnOneTitleDialog extends BaseDialogFragment {
    private LinearLayout llDialog;
    private TextView tvDialogTitle;
    private TextView tvDialogContext;
    private View vDialogLine;
    private TextView tvDialogBtn;
    private OnClickBtn onClickBtn;
    /**
     * 传递实体类
     */
    private BtnOneTitleBean btnOneTitleBean = new BtnOneTitleBean();

    @Override
    protected void initGetData() {
        //获取数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            btnOneTitleBean = bundle.getParcelable("btnOneTitleBean");
        }
    }

    @Override
    protected boolean getCanceledOnTouchOutside() {
        return btnOneTitleBean.isCanceledOnTouchOutside();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_btn_one_title;
    }

    @Override
    protected void initFindById(View mRootView) {
        llDialog = mRootView.findViewById(R.id.ll_dialog);
        tvDialogTitle = mRootView.findViewById(R.id.tv_dialog_title);
        tvDialogContext = mRootView.findViewById(R.id.tv_dialog_context);
        vDialogLine = mRootView.findViewById(R.id.v_dialog_line);
        tvDialogBtn = mRootView.findViewById(R.id.tv_dialog_btn);
    }

    @Override
    protected void initData() { //设置背景样式
        llDialog.setBackgroundResource(btnOneTitleBean.getDialogStyle());
        //设置标题文字
        tvDialogTitle.setText(btnOneTitleBean.getTitleText());
        //设置标题颜色
        tvDialogTitle.setTextColor(ContextCompat.getColor(getActivity(), btnOneTitleBean.getTitleTextColor()));
        //设置标题文字
        tvDialogContext.setText(btnOneTitleBean.getContextText());
        //设置标题颜色
        tvDialogContext.setTextColor(ContextCompat.getColor(getActivity(), btnOneTitleBean.getContextTextColor()));
        //设置线条颜色
        vDialogLine.setBackgroundColor(ContextCompat.getColor(getActivity(), btnOneTitleBean.getLineColor()));
        //设置按钮文字
        tvDialogBtn.setText(btnOneTitleBean.getBtnText());
        //设置按钮颜色
        tvDialogBtn.setTextColor(ContextCompat.getColor(getActivity(), btnOneTitleBean.getBtnTextColor()));
    }

    @Override
    protected void initListener() {
        //点击事件
        tvDialogBtn.setOnClickListener(v -> {
            if (onClickBtn != null) {
                onClickBtn.clickBtn();
            }
        });
    }

    /**
     * 设置点击事件
     *
     * @param onClickBtn 接口
     */
    public void setOnClickConfirm(OnClickBtn onClickBtn) {
        this.onClickBtn = onClickBtn;
    }

    public interface OnClickBtn {
        /**
         * 点击事件
         */
        void clickBtn();
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        //设置宽高
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置中间
        attributes.gravity = Gravity.CENTER;
        window.setAttributes(attributes);
    }
}