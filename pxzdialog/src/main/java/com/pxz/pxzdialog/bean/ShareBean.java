package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * 类说明：分享dialog的实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/21 15:11
 */
public class ShareBean implements Parcelable {
    /**
     * 布局样式
     */
    private int dialogStyle;
    /**
     * 列表数据
     */
    private ArrayList<ShareListBean> shareListBeans;
    /**
     * 一行多少个
     */
    private int number;
    /**
     * 分割线颜色
     */
    private int lineColor;
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

    public ShareBean() {
    }

    public ShareBean(int dialogStyle, ArrayList<ShareListBean> shareListBeans, int number, int lineColor, String btnText, int btnTextColor, boolean isCanceledOnTouchOutside) {
        this.dialogStyle = dialogStyle;
        this.shareListBeans = shareListBeans;
        this.number = number;
        this.lineColor = lineColor;
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

    public ArrayList<ShareListBean> getShareListBeans() {
        return shareListBeans;
    }

    public void setShareListBeans(ArrayList<ShareListBean> shareListBeans) {
        this.shareListBeans = shareListBeans;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
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
        dest.writeTypedList(this.shareListBeans);
        dest.writeInt(this.number);
        dest.writeInt(this.lineColor);
        dest.writeString(this.btnText);
        dest.writeInt(this.btnTextColor);
        dest.writeByte(this.isCanceledOnTouchOutside ? (byte) 1 : (byte) 0);
    }

    protected ShareBean(Parcel in) {
        this.dialogStyle = in.readInt();
        this.shareListBeans = in.createTypedArrayList(ShareListBean.CREATOR);
        this.number = in.readInt();
        this.lineColor = in.readInt();
        this.btnText = in.readString();
        this.btnTextColor = in.readInt();
        this.isCanceledOnTouchOutside = in.readByte() != 0;
    }

    public static final Creator<ShareBean> CREATOR = new Creator<ShareBean>() {
        @Override
        public ShareBean createFromParcel(Parcel source) {
            return new ShareBean(source);
        }

        @Override
        public ShareBean[] newArray(int size) {
            return new ShareBean[size];
        }
    };
}