package com.pxz.pxzdialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pxz.pxzdialog.base.BaseDialogFragment;
import com.pxz.pxzdialog.bean.BtnTwoTitleBean;

import androidx.core.content.ContextCompat;

/**
 * 类说明：带标题的两个按钮的dialog
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/26 10:55
 */
public class BtnTwoTitleDialog extends BaseDialogFragment {
    private LinearLayout llDialog;
    private TextView tvDialogTitle;
    private TextView tvDialogContext;
    private View vDialogLine;
    private TextView tvDialogLeft;
    private View vDialogLine1;
    private TextView tvDialogRight;
    private OnClickBtn onClickBtn;
    /**
     * 传递实体类
     */
    private BtnTwoTitleBean btnTwoTitleBean = new BtnTwoTitleBean();

    @Override
    protected void initGetData() {
        //获取数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            btnTwoTitleBean = bundle.getParcelable("btnTwoTitleBean");
        }
    }

    @Override
    protected boolean getCanceledOnTouchOutside() {
        return btnTwoTitleBean.isCanceledOnTouchOutside();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_btn_two_title;
    }

    @Override
    protected void initFindById(View mRootView) {
        llDialog = mRootView.findViewById(R.id.ll_dialog);
        tvDialogTitle = mRootView.findViewById(R.id.tv_dialog_title);
        tvDialogContext = mRootView.findViewById(R.id.tv_dialog_context);
        vDialogLine = mRootView.findViewById(R.id.v_dialog_line);
        tvDialogLeft = mRootView.findViewById(R.id.tv_dialog_left);
        vDialogLine1 = mRootView.findViewById(R.id.v_dialog_line_1);
        tvDialogRight = mRootView.findViewById(R.id.tv_dialog_right);
    }

    @Override
    protected void initData() {
        //设置背景样式
        llDialog.setBackgroundResource(btnTwoTitleBean.getDialogStyle());
        //设置标题文字
        tvDialogTitle.setText(btnTwoTitleBean.getTitleText());
        //设置标题颜色
        tvDialogTitle.setTextColor(ContextCompat.getColor(getActivity(), btnTwoTitleBean.getTitleTextColor()));
        //设置标题文字
        tvDialogContext.setText(btnTwoTitleBean.getContextText());
        //设置标题颜色
        tvDialogContext.setTextColor(ContextCompat.getColor(getActivity(), btnTwoTitleBean.getContextTextColor()));
        //设置线条颜色
        vDialogLine.setBackgroundColor(ContextCompat.getColor(getActivity(), btnTwoTitleBean.getLineColor()));
        //设置左边按钮文字
        tvDialogLeft.setText(btnTwoTitleBean.getBtnLeftText());
        //设置左边按钮颜色
        tvDialogLeft.setTextColor(ContextCompat.getColor(getActivity(), btnTwoTitleBean.getBtnLeftTextColor()));
        //设置线条颜色
        vDialogLine1.setBackgroundColor(ContextCompat.getColor(getActivity(), btnTwoTitleBean.getLineColor()));
        //设置右边按钮文字
        tvDialogRight.setText(btnTwoTitleBean.getBtnRightText());
        //设置右边按钮颜色
        tvDialogRight.setTextColor(ContextCompat.getColor(getActivity(), btnTwoTitleBean.getBtnRightTextColor()));
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