package com.pxz.pxzdialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.pxz.pxzdialog.adapter.ListBottomAdapter;
import com.pxz.pxzdialog.base.BaseDialogFragment;
import com.pxz.pxzdialog.bean.ListBottomBean;
import com.pxz.pxzdialog.bean.ListBottomListBean;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 类说明：底部弹出的listdialog
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/9/20 11:02
 */
public class ListBottomDialog extends BaseDialogFragment {
    private RecyclerView rvDialog;
    private TextView tvDialogBtn;
    private ListBottomAdapter listBottomAdapter;
    private OnClickBtn onClickBtn;
    /**
     * 传递实体类
     */
    private ListBottomBean listBottomBean;

    @Override
    protected void initGetData() {
        //获取数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            listBottomBean = bundle.getParcelable("listBottomBean");
        }
    }

    @Override
    protected boolean getCanceledOnTouchOutside() {
        return listBottomBean.isCanceledOnTouchOutside();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_list_bottom;
    }

    @Override
    protected void initFindById(View mRootView) {
        rvDialog = mRootView.findViewById(R.id.rv_dialog);
        tvDialogBtn = mRootView.findViewById(R.id.tv_dialog_btn);
    }

    @Override
    protected void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvDialog.setLayoutManager(linearLayoutManager);
        listBottomAdapter = new ListBottomAdapter(getActivity(), listBottomBean.getListBottomListBeans());
        rvDialog.setAdapter(listBottomAdapter);
        tvDialogBtn.setText(listBottomBean.getBtnText());
        tvDialogBtn.setTextColor(ContextCompat.getColor(getActivity(), listBottomBean.getBtnTextColor()));
    }

    @Override
    protected void initListener() {
        //选择
        listBottomAdapter.setAdapterOnClick(listBottomListBean -> {
            if (onClickBtn!=null){
                onClickBtn.clickAdapter(listBottomListBean);
            }
        });
        //按钮点击
        tvDialogBtn.setOnClickListener(v -> {
            if (onClickBtn!=null){
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
        void clickAdapter(ListBottomListBean listBottomListBean);

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