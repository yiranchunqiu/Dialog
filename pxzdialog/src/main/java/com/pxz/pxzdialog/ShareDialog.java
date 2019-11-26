package com.pxz.pxzdialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pxz.pxzdialog.adapter.ShareAdapter;
import com.pxz.pxzdialog.base.BaseDialogFragment;
import com.pxz.pxzdialog.bean.ShareBean;
import com.pxz.pxzdialog.bean.ShareListBean;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 类说明：分享dialog
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/9/20 11:02
 */
public class ShareDialog extends BaseDialogFragment {
    private LinearLayout llDialog;
    private RecyclerView rvDialog;
    private View vDialogLine;
    private TextView tvDialogBtn;
    private ShareAdapter shareAdapter;
    private OnClickBtn onClickBtn;
    /**
     * 传递实体类
     */
    private ShareBean shareBean = new ShareBean();

    @Override
    protected void initGetData() {
        //获取数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            shareBean = bundle.getParcelable("shareBean");
        }
    }

    @Override
    protected boolean getCanceledOnTouchOutside() {
        return shareBean.isCanceledOnTouchOutside();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_share;
    }

    @Override
    protected void initFindById(View mRootView) {
        llDialog = mRootView.findViewById(R.id.ll_dialog);
        rvDialog = mRootView.findViewById(R.id.rv_dialog);
        vDialogLine = mRootView.findViewById(R.id.v_dialog_line);
        tvDialogBtn = mRootView.findViewById(R.id.tv_dialog_btn);
    }

    @Override
    protected void initData() {
        llDialog.setBackgroundResource(shareBean.getDialogStyle());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), shareBean.getNumber());
        rvDialog.setLayoutManager(gridLayoutManager);
        shareAdapter = new ShareAdapter(getActivity(), shareBean.getShareListBeans());
        rvDialog.setAdapter(shareAdapter);
        vDialogLine.setBackgroundColor(ContextCompat.getColor(getActivity(), shareBean.getLineColor()));
        tvDialogBtn.setText(shareBean.getBtnText());
        tvDialogBtn.setTextColor(ContextCompat.getColor(getActivity(), shareBean.getBtnTextColor()));
    }

    @Override
    protected void initListener() {
        //选择
        shareAdapter.setAdapterOnClick(shareListBean -> {
            if (onClickBtn != null) {
                onClickBtn.clickAdapter(shareListBean);
            }
        });
        //按钮点击
        tvDialogBtn.setOnClickListener(v -> {
            if (onClickBtn != null) {
                onClickBtn.clickBtn();
            }
        });
    }

    /**
     * 点击事件
     *
     * @param onClickBtn 接口
     */
    public void setOnClickBtn(OnClickBtn onClickBtn) {
        this.onClickBtn = onClickBtn;
    }

    public interface OnClickBtn {
        /**
         * 选中
         */
        void clickAdapter(ShareListBean shareListBean);

        /**
         * 按钮
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
        //设置底部
        attributes.gravity = Gravity.BOTTOM;
        //设置动画
        attributes.windowAnimations = R.style.DialogAnimations;
        window.setAttributes(attributes);
    }
}