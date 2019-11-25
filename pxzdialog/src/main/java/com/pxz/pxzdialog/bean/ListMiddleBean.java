package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * 类说明：中间列表dialog实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/21 17:39
 */
public class ListMiddleBean implements Parcelable {
    /**
     * 布局样式
     */
    private int dialogStyle;
    /**
     * 标题文字
     */
    private String titleText;
    /**
     * 标题颜色
     */
    private int titleTextColor;
    /**
     * 列表数据
     */
    private ArrayList<ListMiddleListBean> listMiddleListBeans;
    /**
     * 按钮文字
     */
    private String btnText;
    /**
     * 按钮颜色
     */
    private int btnTextColor;
    /**
     * 点击空白处是否消失
     */
    private boolean isCanceledOnTouchOutside;

    public ListMiddleBean() {
    }

    public ListMiddleBean(int dialogStyle, String titleText, int titleTextColor, ArrayList<ListMiddleListBean> listMiddleListBeans, String btnText, int btnTextColor, boolean isCanceledOnTouchOutside) {
        this.dialogStyle = dialogStyle;
        this.titleText = titleText;
        this.titleTextColor = titleTextColor;
        this.listMiddleListBeans = listMiddleListBeans;
        this.btnText = btnText;
        this.btnTextColor = btnTextColor;
        this.isCanceledOnTouchOutside = isCanceledOnTouchOutside;
    }

    public int getDialogStyle() {
        return dialogStyle;
    }

    public void setDialogStyle(int dialogStyle) {
        this.dialogStyle = dialogStyle;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public int getTitleTextColor() {
        return titleTextColor;
    }

    public void setTitleTextColor(int titleTextColor) {
        this.titleTextColor = titleTextColor;
    }

    public ArrayList<ListMiddleListBean> getListMiddleListBeans() {
        return listMiddleListBeans;
    }

    public void setListMiddleListBeans(ArrayList<ListMiddleListBean> listMiddleListBeans) {
        this.listMiddleListBeans = listMiddleListBeans;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }

    public int getBtnTextColor() {
        return btnTextColor;
    }

    public void setBtnTextColor(int btnTextColor) {
        this.btnTextColor = btnTextColor;
    }

    public boolean isCanceledOnTouchOutside() {
        return isCanceledOnTouchOutside;
    }

    public void setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        isCanceledOnTouchOutside = canceledOnTouchOutside;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.dialogStyle);
        dest.writeString(this.titleText);
        dest.writeInt(this.titleTextColor);
        dest.writeTypedList(this.listMiddleListBeans);
        dest.writeString(this.btnText);
        dest.writeInt(this.btnTextColor);
        dest.writeByte(this.isCanceledOnTouchOutside ? (byte) 1 : (byte) 0);
    }

    protected ListMiddleBean(Parcel in) {
        this.dialogStyle = in.readInt();
        this.titleText = in.readString();
        this.titleTextColor = in.readInt();
        this.listMiddleListBeans = in.createTypedArrayList(ListMiddleListBean.CREATOR);
        this.btnText = in.readString();
        this.btnTextColor = in.readInt();
        this.isCanceledOnTouchOutside = in.readByte() != 0;
    }

    public static final Creator<ListMiddleBean> CREATOR = new Creator<ListMiddleBean>() {
        @Override
        public ListMiddleBean createFromParcel(Parcel source) {
            return new ListMiddleBean(source);
        }

        @Override
        public ListMiddleBean[] newArray(int size) {
            return new ListMiddleBean[size];
        }
    };
}