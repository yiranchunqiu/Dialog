package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 类说明：带标题的两个按钮的dialog的实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/26 14:01
 */
public class BtnTwoTitleBean implements Parcelable {
    /**
     * 布局样式
     */
    private int dialogStyle;
    /**
     * 标题文字
     */
    private String titleText;
    /**
     * 标题文字颜色
     */
    private int titleTextColor;
    /**
     * 内容文字
     */
    private String contextText;
    /**
     * 内容文字颜色
     */
    private int contextTextColor;
    /**
     * 分割线颜色
     */
    private int lineColor;
    /**
     * 左边按钮文字
     */
    private String btnLeftText;
    /**
     * 左边按钮文字颜色
     */
    private int btnLeftTextColor;
    /**
     * 右边按钮文字
     */
    private String btnRightText;
    /**
     * 右边按钮文字颜色
     */
    private int btnRightTextColor;
    /**
     * 点击空白处是否消失
     */
    private boolean isCanceledOnTouchOutside;

    public BtnTwoTitleBean() {
    }

    public BtnTwoTitleBean(int dialogStyle, String titleText, int titleTextColor, String contextText, int contextTextColor, int lineColor, String btnLeftText, int btnLeftTextColor, String btnRightText, int btnRightTextColor, boolean isCanceledOnTouchOutside) {
        this.dialogStyle = dialogStyle;
        this.titleText = titleText;
        this.titleTextColor = titleTextColor;
        this.contextText = contextText;
        this.contextTextColor = contextTextColor;
        this.lineColor = lineColor;
        this.btnLeftText = btnLeftText;
        this.btnLeftTextColor = btnLeftTextColor;
        this.btnRightText = btnRightText;
        this.btnRightTextColor = btnRightTextColor;
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

    public String getContextText() {
        return contextText;
    }

    public void setContextText(String contextText) {
        this.contextText = contextText;
    }

    public int getContextTextColor() {
        return contextTextColor;
    }

    public void setContextTextColor(int contextTextColor) {
        this.contextTextColor = contextTextColor;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

    public String getBtnLeftText() {
        return btnLeftText;
    }

    public void setBtnLeftText(String btnLeftText) {
        this.btnLeftText = btnLeftText;
    }

    public int getBtnLeftTextColor() {
        return btnLeftTextColor;
    }

    public void setBtnLeftTextColor(int btnLeftTextColor) {
        this.btnLeftTextColor = btnLeftTextColor;
    }

    public String getBtnRightText() {
        return btnRightText;
    }

    public void setBtnRightText(String btnRightText) {
        this.btnRightText = btnRightText;
    }

    public int getBtnRightTextColor() {
        return btnRightTextColor;
    }

    public void setBtnRightTextColor(int btnRightTextColor) {
        this.btnRightTextColor = btnRightTextColor;
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
        dest.writeString(this.contextText);
        dest.writeInt(this.contextTextColor);
        dest.writeInt(this.lineColor);
        dest.writeString(this.btnLeftText);
        dest.writeInt(this.btnLeftTextColor);
        dest.writeString(this.btnRightText);
        dest.writeInt(this.btnRightTextColor);
        dest.writeByte(this.isCanceledOnTouchOutside ? (byte) 1 : (byte) 0);
    }

    protected BtnTwoTitleBean(Parcel in) {
        this.dialogStyle = in.readInt();
        this.titleText = in.readString();
        this.titleTextColor = in.readInt();
        this.contextText = in.readString();
        this.contextTextColor = in.readInt();
        this.lineColor = in.readInt();
        this.btnLeftText = in.readString();
        this.btnLeftTextColor = in.readInt();
        this.btnRightText = in.readString();
        this.btnRightTextColor = in.readInt();
        this.isCanceledOnTouchOutside = in.readByte() != 0;
    }

    public static final Creator<BtnTwoTitleBean> CREATOR = new Creator<BtnTwoTitleBean>() {
        @Override
        public BtnTwoTitleBean createFromParcel(Parcel source) {
            return new BtnTwoTitleBean(source);
        }

        @Override
        public BtnTwoTitleBean[] newArray(int size) {
            return new BtnTwoTitleBean[size];
        }
    };
}