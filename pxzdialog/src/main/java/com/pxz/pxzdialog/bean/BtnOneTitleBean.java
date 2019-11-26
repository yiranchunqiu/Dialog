package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 类说明：带标题的一个按钮的dialog的实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/26 14:00
 */
public class BtnOneTitleBean implements Parcelable {
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
     * 按钮文字
     */
    private String btnText;
    /**
     * 按钮文字颜色
     */
    private int btnTextColor;
    /**
     * 点击空白处是否消失
     */
    private boolean isCanceledOnTouchOutside;

    public BtnOneTitleBean() {
    }

    public BtnOneTitleBean(int dialogStyle, String titleText, int titleTextColor, String contextText, int contextTextColor, int lineColor, String btnText, int btnTextColor, boolean isCanceledOnTouchOutside) {
        this.dialogStyle = dialogStyle;
        this.titleText = titleText;
        this.titleTextColor = titleTextColor;
        this.contextText = contextText;
        this.contextTextColor = contextTextColor;
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
        dest.writeString(this.contextText);
        dest.writeInt(this.contextTextColor);
        dest.writeInt(this.lineColor);
        dest.writeString(this.btnText);
        dest.writeInt(this.btnTextColor);
        dest.writeByte(this.isCanceledOnTouchOutside ? (byte) 1 : (byte) 0);
    }

    protected BtnOneTitleBean(Parcel in) {
        this.dialogStyle = in.readInt();
        this.titleText = in.readString();
        this.titleTextColor = in.readInt();
        this.contextText = in.readString();
        this.contextTextColor = in.readInt();
        this.lineColor = in.readInt();
        this.btnText = in.readString();
        this.btnTextColor = in.readInt();
        this.isCanceledOnTouchOutside = in.readByte() != 0;
    }

    public static final Creator<BtnOneTitleBean> CREATOR = new Creator<BtnOneTitleBean>() {
        @Override
        public BtnOneTitleBean createFromParcel(Parcel source) {
            return new BtnOneTitleBean(source);
        }

        @Override
        public BtnOneTitleBean[] newArray(int size) {
            return new BtnOneTitleBean[size];
        }
    };
}