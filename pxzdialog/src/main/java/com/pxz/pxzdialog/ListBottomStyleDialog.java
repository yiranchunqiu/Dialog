package com.pxz.pxzdialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pxz.pxzdialog.adapter.ListBottomStyleAdapter;
import com.pxz.pxzdialog.base.BaseDialogFragment;
import com.pxz.pxzdialog.bean.ListBottomStyleBean;
import com.pxz.pxzdialog.bean.ListBottomStyleListBean;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 类说明：底部弹出带有样式的listdialog
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/22 15:13
 */
public class ListBottomStyleDialog extends BaseDialogFragment {
    private LinearLayout llDialog;
    private RecyclerView rvDialog;
    private TextView tvDialogBtn;
    private ListBottomStyleAdapter listBottomStyleAdapter;
    private OnClickBtn onClickBtn;
    /**
     * 传递实体类
     */
    private ListBottomStyleBean listBottomStyleBean = new ListBottomStyleBean();

    @Override
    protected void initGetData() {
        //获取数据
        Bundle bundle = getArguments();
        if (bundle != null) {
            listBottomStyleBean = bundle.getParcelable("listBottomStyleBean");
        }
    }

    @Override
    protected boolean getCanceledOnTouchOutside() {
        return listBottomStyleBean.isCanceledOnTouchOutside();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_list_bottom_style;
    }

    @Override
    protected void initFindById(View mRootView) {
        llDialog = mRootView.findViewById(R.id.ll_dialog);
        rvDialog = mRootView.findViewById(R.id.rv_dialog);
        tvDialogBtn = mRootView.findViewById(R.id.tv_dialog_btn);
    }

    @Override
    protected void initData() {
        llDialog.setBackgroundResource(listBottomStyleBean.getDialogStyle());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvDialog.setLayoutManager(linearLayoutManager);
        listBottomStyleAdapter = new ListBottomStyleAdapter(getActivity(), listBottomStyleBean.getListBottomStyleListBeans());
        rvDialog.setAdapter(listBottomStyleAdapter);
        tvDialogBtn.setText(listBottomStyleBean.getBtnText());
        tvDialogBtn.setTextColor(ContextCompat.getColor(getActivity(), listBottomStyleBean.getBtnTextColor()));
        tvDialogBtn.setBackgroundResource(listBottomStyleBean.getBtnTextStyle());
    }

    @Override
    protected void initListener() {
        //选择
        listBottomStyleAdapter.setAdapterOnClick(listBottomStyleListBean -> {
            if (onClickBtn != null) {
                onClickBtn.clickAdapter(listBottomStyleListBean);
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
        void clickAdapter(ListBottomStyleListBean listBottomStyleListBean);

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
        //设置底部
        attributes.gravity = Gravity.BOTTOM;
        //设置动画
        attributes.windowAnimations = R.style.DialogAnimations;
        window.setAttributes(attributes);
    }
}