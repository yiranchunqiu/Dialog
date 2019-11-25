package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * 类说明：底部列表带样式的dialog实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/22 15:20
 */
public class ListBottomStyleBean implements Parcelable {
    /**
     * 布局样式
     */
    private int dialogStyle;
    /**
     * 列表数据
     */
    private ArrayList<ListBottomStyleListBean> listBottomStyleListBeans;
    /**
     * 按钮文字
     */
    private String btnText;
    /**
     * 按钮颜色
     */
    private int btnTextColor;
    /**
     * 按钮样式
     */
    private int btnTextStyle;
    /**
     * 点击空白处是否消失
     */
    private boolean isCanceledOnTouchOutside;

    public ListBottomStyleBean() {
    }

    public ListBottomStyleBean(int dialogStyle, ArrayList<ListBottomStyleListBean> listBottomStyleListBeans, String btnText, int btnTextColor, int btnTextStyle, boolean isCanceledOnTouchOutside) {
        this.dialogStyle = dialogStyle;
        this.listBottomStyleListBeans = listBottomStyleListBeans;
        this.btnText = btnText;
        this.btnTextColor = btnTextColor;
        this.btnTextStyle = btnTextStyle;
        this.isCanceledOnTouchOutside = isCanceledOnTouchOutside;
    }

    public int getDialogStyle() {
        return dialogStyle;
    }

    public void setDialogStyle(int dialogStyle) {
        this.dialogStyle = dialogStyle;
    }

    public ArrayList<ListBottomStyleListBean> getListBottomStyleListBeans() {
        return listBottomStyleListBeans;
    }

    public void setListBottomStyleListBeans(ArrayList<ListBottomStyleListBean> listBottomStyleListBeans) {
        this.listBottomStyleListBeans = listBottomStyleListBeans;
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

    public int getBtnTextStyle() {
        return btnTextStyle;
    }

    public void setBtnTextStyle(int btnTextStyle) {
        this.btnTextStyle = btnTextStyle;
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
        dest.writeTypedList(this.listBottomStyleListBeans);
        dest.writeString(this.btnText);
        dest.writeInt(this.btnTextColor);
        dest.writeInt(this.btnTextStyle);
        dest.writeByte(this.isCanceledOnTouchOutside ? (byte) 1 : (byte) 0);
    }

    protected ListBottomStyleBean(Parcel in) {
        this.dialogStyle = in.readInt();
        this.listBottomStyleListBeans = in.createTypedArrayList(ListBottomStyleListBean.CREATOR);
        this.btnText = in.readString();
        this.btnTextColor = in.readInt();
        this.btnTextStyle = in.readInt();
        this.isCanceledOnTouchOutside = in.readByte() != 0;
    }

    public static final Creator<ListBottomStyleBean> CREATOR = new Creator<ListBottomStyleBean>() {
        @Override
        public ListBottomStyleBean createFromParcel(Parcel source) {
            return new ListBottomStyleBean(source);
        }

        @Override
        public ListBottomStyleBean[] newArray(int size) {
            return new ListBottomStyleBean[size];
        }
    };
}