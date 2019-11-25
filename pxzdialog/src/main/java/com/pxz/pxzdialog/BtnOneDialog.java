package com.pxz.pxzdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pxz.pxzdialog.base.BaseDialogFragment;
import com.pxz.pxzdialog.bean.BtnOneBean;

import androidx.core.content.ContextCompat;

/**
 * 类说明：一个按钮的dialog
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/9/12 10:18
 */
public class BtnOneDialog extends BaseDialogFragment {
    private LinearLayout llDialog;
    private TextView tvDialogTitle;
    private View vDialogLine;
    private TextView tvDialogBtn;
    private OnClickBtn onClickBtn;
    /**
     * 传递实体类
     */
    private BtnOneBean btnOneBean;

    @Override
    protected void initGetData() {
        //获取数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            btnOneBean = bundle.getParcelable("btnOneBean");
        }
    }

    @Override
    protected boolean getCanceledOnTouchOutside() {
        //点击空白是否消失
        return btnOneBean.isCanceledOnTouchOutside();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_btn_one;
    }

    @Override
    protected void initFindById(View mRootView) {
        llDialog = mRootView.findViewById(R.id.ll_dialog);
        tvDialogTitle = mRootView.findViewById(R.id.tv_dialog_title);
        vDialogLine = mRootView.findViewById(R.id.v_dialog_line);
        tvDialogBtn = mRootView.findViewById(R.id.tv_dialog_btn);
    }

    @Override
    protected void initData() {
        //设置背景样式
        llDialog.setBackgroundResource(btnOneBean.getDialogStyle());
        //设置标题文字
        tvDialogTitle.setText(btnOneBean.getTitleText());
        //设置标题颜色
        tvDialogTitle.setTextColor(ContextCompat.getColor(getActivity(), btnOneBean.getTitleTextColor()));
        //设置线条颜色
        vDialogLine.setBackgroundColor(ContextCompat.getColor(getActivity(), btnOneBean.getLineColor()));
        //设置按钮文字
        tvDialogBtn.setText(btnOneBean.getBtnText());
        //设置按钮颜色
        tvDialogBtn.setTextColor(ContextCompat.getColor(getActivity(), btnOneBean.getBtnTextColor()));
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

    public interface OnClickBtn{
        /**
         * 点击事件
         */
        void clickBtn();
    }
}