package com.pxz.pxzdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pxz.pxzdialog.base.BaseDialogFragment;
import com.pxz.pxzdialog.bean.BtnTwoBean;

import androidx.core.content.ContextCompat;

/**
 * 类说明：两个按钮的dialog
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/9/17 14:02
 */
public class BtnTwoDialog extends BaseDialogFragment {
    private LinearLayout llDialog;
    private TextView tvDialogTitle;
    private View vDialogLine;
    private TextView tvDialogLeft;
    private View vDialogLine1;
    private TextView tvDialogRight;
    private OnClickBtn onClickBtn;
    /**
     * 传递实体类
     */
    private BtnTwoBean btnTwoBean;

    @Override
    protected void initGetData() {
        //获取数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            btnTwoBean = bundle.getParcelable("btnTwoBean");
        }
    }

    @Override
    protected boolean getCanceledOnTouchOutside() {
        return btnTwoBean.isCanceledOnTouchOutside();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_btn_two;
    }

    @Override
    protected void initFindById(View mRootView) {
        llDialog = mRootView.findViewById(R.id.ll_dialog);
        tvDialogTitle = mRootView.findViewById(R.id.tv_dialog_title);
        vDialogLine = mRootView.findViewById(R.id.v_dialog_line);
        tvDialogLeft = mRootView.findViewById(R.id.tv_dialog_left);
        vDialogLine1 = mRootView.findViewById(R.id.v_dialog_line_1);
        tvDialogRight = mRootView.findViewById(R.id.tv_dialog_right);
    }

    @Override
    protected void initData() {
        //设置背景样式
        llDialog.setBackgroundResource(btnTwoBean.getDialogStyle());
        //设置标题文字
        tvDialogTitle.setText(btnTwoBean.getTitleText());
        //设置标题颜色
        tvDialogTitle.setTextColor(ContextCompat.getColor(getActivity(), btnTwoBean.getTitleTextColor()));
        //设置线条颜色
        vDialogLine.setBackgroundColor(ContextCompat.getColor(getActivity(), btnTwoBean.getLineColor()));
        //设置左边按钮文字
        tvDialogLeft.setText(btnTwoBean.getBtnLeftText());
        //设置左边按钮颜色
        tvDialogLeft.setTextColor(ContextCompat.getColor(getActivity(), btnTwoBean.getBtnLeftTextColor()));
        //设置线条颜色
        vDialogLine1.setBackgroundColor(ContextCompat.getColor(getActivity(), btnTwoBean.getLineColor()));
        //设置右边按钮文字
        tvDialogRight.setText(btnTwoBean.getBtnRightText());
        //设置右边按钮颜色
        tvDialogRight.setTextColor(ContextCompat.getColor(getActivity(), btnTwoBean.getBtnRightTextColor()));
    }

    @Override
    protected void initListener() {
        //左边点击事件
        tvDialogLeft.setOnClickListener(v -> {
            if (onClickBtn != null) {
                onClickBtn.clickBtnLeft();
            }
        });
        //右边点击事件
        tvDialogRight.setOnClickListener(v -> {
            if (onClickBtn != null) {
                onClickBtn.clickBtnRight();
            }
        });
    }

    /**
     * 设置点击事件
     *
     * @param onClickBtn 接口
     */
    public void setOnClickBtn(OnClickBtn onClickBtn) {
        this.onClickBtn = onClickBtn;
    }

    public interface OnClickBtn {
        /**
         * 左边点击事件
         */
        void clickBtnLeft();

        /**
         * 右边点击事件
         */
        void clickBtnRight();
    }
}
