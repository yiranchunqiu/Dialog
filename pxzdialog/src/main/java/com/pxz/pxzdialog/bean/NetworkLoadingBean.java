package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 类说明：
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/27 12:59
 */
public class NetworkLoadingBean implements Parcelable {
    /**
     * 布局样式
     */
    private int dialogStyle;
    /**
     * 布局样式
     */
    private int progressbarStyle;
    /**
     * 标题文字
     */
    private String titleText;
    /**
     * 标题颜色
     */
    private int titleTextColor;
    /**
     * 点击空白处是否消失
     */
    private boolean isCanceledOnTouchOutside;

    public NetworkLoadingBean(int dialogStyle, int progressbarStyle, String titleText, int titleTextColor, boolean isCanceledOnTouchOutside) {
        this.dialogStyle = dialogStyle;
        this.progressbarStyle = progressbarStyle;
        this.titleText = titleText;
        this.titleTextColor = titleTextColor;
        this.isCanceledOnTouchOutside = isCanceledOnTouchOutside;
    }

    public NetworkLoadingBean() {
    }

    public int getDialogStyle() {
        return dialogStyle;
    }

    public void setDialogStyle(int dialogStyle) {
        this.dialogStyle = dialogStyle;
    }

    public int getProgressbarStyle() {
        return progressbarStyle;
    }

    public void setProgressbarStyle(int progressbarStyle) {
        this.progressbarStyle = progressbarStyle;
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
        dest.writeInt(this.progressbarStyle);
        dest.writeString(this.titleText);
        dest.writeInt(this.titleTextColor);
        dest.writeByte(this.isCanceledOnTouchOutside ? (byte) 1 : (byte) 0);
    }

    protected NetworkLoadingBean(Parcel in) {
        this.dialogStyle = in.readInt();
        this.progressbarStyle = in.readInt();
        this.titleText = in.readString();
        this.titleTextColor = in.readInt();
        this.isCanceledOnTouchOutside = in.readByte() != 0;
    }

    public static final Creator<NetworkLoadingBean> CREATOR = new Creator<NetworkLoadingBean>() {
        @Override
        public NetworkLoadingBean createFromParcel(Parcel source) {
            return new NetworkLoadingBean(source);
        }

        @Override
        public NetworkLoadingBean[] newArray(int size) {
            return new NetworkLoadingBean[size];
        }
    };
}