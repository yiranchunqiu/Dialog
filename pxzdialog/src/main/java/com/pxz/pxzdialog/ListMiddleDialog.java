package com.pxz.pxzdialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pxz.pxzdialog.adapter.ListMiddleAdapter;
import com.pxz.pxzdialog.base.BaseDialogFragment;
import com.pxz.pxzdialog.bean.ListMiddleBean;
import com.pxz.pxzdialog.bean.ListMiddleListBean;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 类说明：
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/6 14:12
 */
public class ListMiddleDialog extends BaseDialogFragment {
    private LinearLayout llDialog;
    private TextView tvDialogTitle;
    private RecyclerView rvDialog;
    private TextView tvDialogBtn;
    private ListMiddleAdapter listMiddleAdapter;
    private OnClickBtn onClickBtn;
    /**
     * 传递实体类
     */
    private ListMiddleBean listMiddleBean = new ListMiddleBean();

    @Override
    protected void initGetData() {
        //获取数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            listMiddleBean = bundle.getParcelable("listMiddleBean");
        }
    }

    @Override
    protected boolean getCanceledOnTouchOutside() {
        return listMiddleBean.isCanceledOnTouchOutside();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_list_middle;
    }

    @Override
    protected void initFindById(View mRootView) {
        llDialog = mRootView.findViewById(R.id.ll_dialog);
        tvDialogTitle = mRootView.findViewById(R.id.tv_dialog_title);
        rvDialog = mRootView.findViewById(R.id.rv_dialog);
        tvDialogBtn = mRootView.findViewById(R.id.tv_dialog_btn);
    }

    @Override
    protected void initData() {
        llDialog.setBackgroundResource(listMiddleBean.getDialogStyle());
        tvDialogTitle.setText(listMiddleBean.getTitleText());
        tvDialogTitle.setTextColor(ContextCompat.getColor(getActivity(), listMiddleBean.getTitleTextColor()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvDialog.setLayoutManager(linearLayoutManager);
        listMiddleAdapter = new ListMiddleAdapter(getActivity(), listMiddleBean.getListMiddleListBeans());
        rvDialog.setAdapter(listMiddleAdapter);
        tvDialogBtn.setText(listMiddleBean.getBtnText());
        tvDialogBtn.setTextColor(ContextCompat.getColor(getActivity(), listMiddleBean.getBtnTextColor()));
    }

    @Override
    protected void initListener() {
        //选择
        listMiddleAdapter.setAdapterOnClick(listMiddleListBeans -> {
            if (onClickBtn != null) {
                onClickBtn.clickAdapter(listMiddleListBeans);
            }
        });
        //按钮点击
        tvDialogBtn.setOnClickListener(v -> {
            if (onClickBtn != null) {
                onClickBtn.clickBtn();
            }
        });
    }

    public void setOnClickBtn(OnClickBtn onClickBtn) {
        this.onClickBtn = onClickBtn;
    }

    public interface OnClickBtn {
        /**
         * 选中
         */
        void clickAdapter(ListMiddleListBean listMiddleListBean);

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
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.gravity = Gravity.CENTER;
        window.setAttributes(attributes);
    }
}