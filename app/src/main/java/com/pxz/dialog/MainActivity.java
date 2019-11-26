package com.pxz.dialog;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.pxz.pxzdialog.BtnOneTitleDialog;
import com.pxz.pxzdialog.BtnTwoTitleDialog;
import com.pxz.pxzdialog.ListBottomDialog;
import com.pxz.pxzdialog.ListBottomStyleDialog;
import com.pxz.pxzdialog.ListMiddleDialog;
import com.pxz.pxzdialog.ShareDialog;
import com.pxz.pxzdialog.BtnOneDialog;
import com.pxz.pxzdialog.BtnTwoDialog;
import com.pxz.pxzdialog.bean.BtnOneBean;
import com.pxz.pxzdialog.bean.BtnOneTitleBean;
import com.pxz.pxzdialog.bean.BtnTwoBean;
import com.pxz.pxzdialog.bean.BtnTwoTitleBean;
import com.pxz.pxzdialog.bean.ListBottomBean;
import com.pxz.pxzdialog.bean.ListBottomListBean;
import com.pxz.pxzdialog.bean.ListBottomStyleBean;
import com.pxz.pxzdialog.bean.ListBottomStyleListBean;
import com.pxz.pxzdialog.bean.ListMiddleBean;
import com.pxz.pxzdialog.bean.ListMiddleListBean;
import com.pxz.pxzdialog.bean.ShareBean;
import com.pxz.pxzdialog.bean.ShareListBean;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/**
 * 类说明：首页
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/21 10:42
 */
public class MainActivity extends AppCompatActivity {
    private TextView tvDialogOne;
    private TextView tvDialogTwo;
    private TextView tvDialogShare;
    private TextView tvDialogListBottom;
    private TextView tvDialogListBottomStyle;
    private TextView tvDialogListMiddle;
    private TextView tvDialogOneTitle;
    private TextView tvDialogTwoTitle;
    /**
     * 实体类
     */
    private BtnOneBean btnOneBean;
    /**
     * 一个按钮弹窗
     */
    private BtnOneDialog btnOneDialog;
    /**
     * 实体类
     */
    private BtnTwoBean btnTwoBean;
    /**
     * 两个按钮弹窗
     */
    private BtnTwoDialog btnTwoDialog;
    /**
     * 实体类
     */
    private ShareBean shareBean;
    /**
     * 分享弹窗
     */
    private ShareDialog shareDialog;
    /**
     * 实体类
     */
    private ListBottomBean listBottomBean;
    /**
     * 底部弹窗
     */
    private ListBottomDialog listBottomDialog;
    /**
     * 实体类
     */
    private ListBottomStyleBean listBottomStyleBean;
    /**
     * 底部样式弹窗
     */
    private ListBottomStyleDialog listBottomStyleDialog;
    /**
     * 实体类
     */
    private ListMiddleBean listMiddleBean;
    /**
     * 中间弹窗
     */
    private ListMiddleDialog listMiddleDialog;
    /**
     * 实体类
     */
    private BtnOneTitleBean btnOneTitleBean;
    /**
     * 带标题的一个按钮弹窗
     */
    private BtnOneTitleDialog btnOneTitleDialog;
    /**
     * 实体类
     */
    private BtnTwoTitleBean btnTwoTitleBean;
    /**
     * 带标题的两个个按钮弹窗
     */
    private BtnTwoTitleDialog btnTwoTitleDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        }
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initClick();
    }

    private void initView() {
        tvDialogOne = findViewById(R.id.tv_dialog_one);
        tvDialogTwo = findViewById(R.id.tv_dialog_two);
        tvDialogShare = findViewById(R.id.tv_dialog_share);
        tvDialogListBottom = findViewById(R.id.tv_dialog_list_bottom);
        tvDialogListBottomStyle = findViewById(R.id.tv_dialog_list_bottom_style);
        tvDialogListMiddle = findViewById(R.id.tv_dialog_list_middle);
        tvDialogOneTitle = findViewById(R.id.tv_dialog_one_title);
        tvDialogTwoTitle = findViewById(R.id.tv_dialog_two_title);
    }

    private void initData() {
        //一个按钮
        btnOneBean = new BtnOneBean(R.drawable.dialog_btn_1,
                "标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏", R.color.black,
                R.color.blue,
                "确定按钮", R.color.blue,
                false);
        //两个按钮
        btnTwoBean = new BtnTwoBean(R.drawable.dialog_btn_1,
                "两个按钮标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏标题栏", R.color.black,
                R.color.blue,
                "取消按钮", R.color.gray,
                "确定按钮", R.color.blue,
                false);
        //分享
        ArrayList<ShareListBean> shareListBeans = new ArrayList<>();
        shareListBeans.add(new ShareListBean("1", R.color.black, R.mipmap.fx_icon_kj));
        shareListBeans.add(new ShareListBean("2", R.color.black, R.mipmap.fx_icon_lj));
        shareListBeans.add(new ShareListBean("3", R.color.black, R.mipmap.fx_icon_pyq));
        shareListBeans.add(new ShareListBean("4", R.color.black, R.mipmap.fx_icon_qq));
        shareListBeans.add(new ShareListBean("5", R.color.black, R.mipmap.fx_icon_wb));
        shareListBeans.add(new ShareListBean("6", R.color.black, R.mipmap.fx_icon_wx));
        shareBean = new ShareBean(R.drawable.dialog_share_1,
                shareListBeans,
                4,
                R.color.black,
                "取消", R.color.gray,
                false);
        //底部列表
        ArrayList<ListBottomListBean> listBottomListBeans = new ArrayList<>();
        listBottomListBeans.add(new ListBottomListBean("1", R.color.color_333333));
        listBottomListBeans.add(new ListBottomListBean("2", R.color.color_333333));
        listBottomListBeans.add(new ListBottomListBean("3", R.color.color_333333));
        listBottomListBeans.add(new ListBottomListBean("4", R.color.color_333333));
        listBottomListBeans.add(new ListBottomListBean("5", R.color.color_333333));
        listBottomBean = new ListBottomBean(listBottomListBeans,
                "取消", R.color.gray,
                false);
        //底部样式列表
        ArrayList<ListBottomStyleListBean> listBottomStyleListBeans = new ArrayList<>();
        listBottomStyleListBeans.add(new ListBottomStyleListBean("1", R.color.color_333333));
        listBottomStyleListBeans.add(new ListBottomStyleListBean("2", R.color.color_333333));
        listBottomStyleListBeans.add(new ListBottomStyleListBean("3", R.color.color_333333));
        listBottomStyleListBeans.add(new ListBottomStyleListBean("4", R.color.color_333333));
        listBottomStyleListBeans.add(new ListBottomStyleListBean("5", R.color.color_333333));
        listBottomStyleBean = new ListBottomStyleBean(R.drawable.dialog_2,
                listBottomStyleListBeans,
                "取消", R.color.gray, R.drawable.dialog_2,
                false);
        //中间列表
        ArrayList<ListMiddleListBean> listMiddleListBeans = new ArrayList<>();
        listMiddleListBeans.add(new ListMiddleListBean("1", R.color.color_333333));
        listMiddleListBeans.add(new ListMiddleListBean("2", R.color.color_333333));
        listMiddleListBeans.add(new ListMiddleListBean("3", R.color.color_333333));
        listMiddleListBeans.add(new ListMiddleListBean("4", R.color.color_333333));
        listMiddleListBeans.add(new ListMiddleListBean("5", R.color.color_333333));
        listMiddleBean = new ListMiddleBean(R.drawable.dialog_1,
                "选择", R.color.blue,
                listMiddleListBeans,
                "取消", R.color.gray,
                false);
        //带标题的一个按钮
        btnOneTitleBean = new BtnOneTitleBean(R.drawable.dialog_btn_2,
                "标题栏", R.color.black,
                "内容内容内容", R.color.black,
                R.color.gray,
                "确定按钮", R.color.blue,
                false);
        //带标题的两个按钮
        btnTwoTitleBean = new BtnTwoTitleBean(R.drawable.dialog_btn_2,
                "两个按钮标题", R.color.black,
                "内容内容内容", R.color.black,
                R.color.gray,
                "取消按钮", R.color.gray,
                "确定按钮", R.color.blue,
                false);
    }

    private void initClick() {
        tvDialogOne.setOnClickListener(v -> {
            btnOneDialog = new BtnOneDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("btnOneBean", btnOneBean);
            btnOneDialog.setCancelable(true);
            btnOneDialog.setArguments(bundle);
            btnOneDialog.show(getSupportFragmentManager(), "BtnOneDialog");
            btnOneDialog.setOnClickConfirm(btnOneDialog::dismiss);
        });
        tvDialogTwo.setOnClickListener(v -> {
            btnTwoDialog = new BtnTwoDialog();
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("btnTwoBean", btnTwoBean);
            btnTwoDialog.setCancelable(true);
            btnTwoDialog.setArguments(bundle2);
            btnTwoDialog.show(getSupportFragmentManager(), "BtnTwoDialog");
            btnTwoDialog.setOnClickBtn(new BtnTwoDialog.OnClickBtn() {
                @Override
                public void clickBtnLeft() {
                    btnTwoDialog.dismiss();
                }

                @Override
                public void clickBtnRight() {
                }
            });
        });
        tvDialogShare.setOnClickListener(v -> {
            shareDialog = new ShareDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("shareBean", shareBean);
            shareDialog.setCancelable(true);
            shareDialog.setArguments(bundle);
            shareDialog.show(getSupportFragmentManager(), "ShareDialog");
            shareDialog.setOnClickBtn(new ShareDialog.OnClickBtn() {
                @Override
                public void clickAdapter(ShareListBean shareListBean) {
                }

                @Override
                public void clickBtn() {
                    shareDialog.dismiss();
                }
            });
        });
        tvDialogListBottom.setOnClickListener(v -> {
            listBottomDialog = new ListBottomDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("listBottomBean", listBottomBean);
            listBottomDialog.setCancelable(true);
            listBottomDialog.setArguments(bundle);
            listBottomDialog.show(getSupportFragmentManager(), "ListBottomDialog");
            listBottomDialog.setOnClickBtn(new ListBottomDialog.OnClickBtn() {
                @Override
                public void clickAdapter(ListBottomListBean listBottomListBean) {
                }

                @Override
                public void clickBtn() {
                    listBottomDialog.dismiss();
                }
            });
        });
        tvDialogListBottomStyle.setOnClickListener(v -> {
            listBottomStyleDialog = new ListBottomStyleDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("listBottomStyleBean", listBottomStyleBean);
            listBottomStyleDialog.setCancelable(true);
            listBottomStyleDialog.setArguments(bundle);
            listBottomStyleDialog.show(getSupportFragmentManager(), "ListBottomStyleDialog");
            listBottomStyleDialog.setOnClickBtn(new ListBottomStyleDialog.OnClickBtn() {
                @Override
                public void clickAdapter(ListBottomStyleListBean listBottomStyleListBean) {
                }

                @Override
                public void clickBtn() {
                    listBottomStyleDialog.dismiss();
                }
            });
        });
        tvDialogListMiddle.setOnClickListener(v -> {
            listMiddleDialog = new ListMiddleDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("listMiddleBean", listMiddleBean);
            listMiddleDialog.setCancelable(true);
            listMiddleDialog.setArguments(bundle);
            listMiddleDialog.show(getSupportFragmentManager(), "ListMiddleDialog");
            listMiddleDialog.setOnClickBtn(new ListMiddleDialog.OnClickBtn() {
                @Override
                public void clickAdapter(ListMiddleListBean listMiddleListBean) {
                }

                @Override
                public void clickBtn() {
                    listMiddleDialog.dismiss();
                }
            });
        });
        tvDialogOneTitle.setOnClickListener(v -> {
            btnOneTitleDialog = new BtnOneTitleDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("btnOneTitleBean", btnOneTitleBean);
            btnOneTitleDialog.setCancelable(true);
            btnOneTitleDialog.setArguments(bundle);
            btnOneTitleDialog.show(getSupportFragmentManager(), "BtnOneTitleDialog");
            btnOneTitleDialog.setOnClickConfirm(() -> btnOneTitleDialog.dismiss());
        });
        tvDialogTwoTitle.setOnClickListener(v -> {
            btnTwoTitleDialog = new BtnTwoTitleDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("btnTwoTitleBean", btnTwoTitleBean);
            btnTwoTitleDialog.setCancelable(true);
            btnTwoTitleDialog.setArguments(bundle);
            btnTwoTitleDialog.show(getSupportFragmentManager(), "BtnTwoTitleDialog");
            btnTwoTitleDialog.setOnClickBtn(new BtnTwoTitleDialog.OnClickBtn() {
                @Override
                public void clickBtnLeft() {
                    btnTwoTitleDialog.dismiss();
                }

                @Override
                public void clickBtnRight() {
                }
            });
        });
    }
}