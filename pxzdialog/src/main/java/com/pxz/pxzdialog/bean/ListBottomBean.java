package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * 类说明：底部列表dialog实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/21 17:39
 */
public class ListBottomBean implements Parcelable {
    /**
     * 列表数据
     */
    private ArrayList<ListBottomListBean> listBottomListBeans;
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

    public ListBottomBean() {
    }

    public ListBottomBean( ArrayList<ListBottomListBean> listBottomListBeans, String btnText, int btnTextColor, boolean isCanceledOnTouchOutside) {
        this.listBottomListBeans = listBottomListBeans;
        this.btnText = btnText;
        this.btnTextColor = btnTextColor;
        this.isCanceledOnTouchOutside = isCanceledOnTouchOutside;
    }

    public ArrayList<ListBottomListBean> getListBottomListBeans() {
        return listBottomListBeans;
    }

    public void setListBottomListBeans(ArrayList<ListBottomListBean> listBottomListBeans) {
        this.listBottomListBeans = listBottomListBeans;
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
        dest.writeTypedList(this.listBottomListBeans);
        dest.writeString(this.btnText);
        dest.writeInt(this.btnTextColor);
        dest.writeByte(this.isCanceledOnTouchOutside ? (byte) 1 : (byte) 0);
    }

    protected ListBottomBean(Parcel in) {
        this.listBottomListBeans = in.createTypedArrayList(ListBottomListBean.CREATOR);
        this.btnText = in.readString();
        this.btnTextColor = in.readInt();
        this.isCanceledOnTouchOutside = in.readByte() != 0;
    }

    public static final Creator<ListBottomBean> CREATOR = new Creator<ListBottomBean>() {
        @Override
        public ListBottomBean createFromParcel(Parcel source) {
            return new ListBottomBean(source);
        }

        @Override
        public ListBottomBean[] newArray(int size) {
            return new ListBottomBean[size];
        }
    };
}