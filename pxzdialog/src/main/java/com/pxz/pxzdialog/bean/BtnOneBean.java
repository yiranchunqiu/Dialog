package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 类说明：一个按钮的dialog的实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/21 13:54
 */
public class BtnOneBean implements Parcelable {
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

    public BtnOneBean() {
    }

    public BtnOneBean(int dialogStyle, String titleText, int titleTextColor, int lineColor, String btnText, int btnTextColor, boolean isCanceledOnTouchOutside) {
        this.dialogStyle = dialogStyle;
        this.titleText = titleText;
        this.titleTextColor = titleTextColor;
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
        dest.writeInt(this.lineColor);
        dest.writeString(this.btnText);
        dest.writeInt(this.btnTextColor);
        dest.writeByte(this.isCanceledOnTouchOutside ? (byte) 1 : (byte) 0);
    }

    protected BtnOneBean(Parcel in) {
        this.dialogStyle = in.readInt();
        this.titleText = in.readString();
        this.titleTextColor = in.readInt();
        this.lineColor = in.readInt();
        this.btnText = in.readString();
        this.btnTextColor = in.readInt();
        this.isCanceledOnTouchOutside = in.readByte() != 0;
    }

    public static final Creator<BtnOneBean> CREATOR = new Creator<BtnOneBean>() {
        @Override
        public BtnOneBean createFromParcel(Parcel source) {
            return new BtnOneBean(source);
        }

        @Override
        public BtnOneBean[] newArray(int size) {
            return new BtnOneBean[size];
        }
    };
}