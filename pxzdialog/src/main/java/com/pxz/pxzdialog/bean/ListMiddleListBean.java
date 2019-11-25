package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 类说明：中间列表dialog的列表实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/21 17:40
 */
public class ListMiddleListBean implements Parcelable {
    private String listMiddleTtile;
    private int listMiddleTtileColor;

    public ListMiddleListBean() {
    }

    public ListMiddleListBean(String listMiddleTtile, int listMiddleTtileColor) {
        this.listMiddleTtile = listMiddleTtile;
        this.listMiddleTtileColor = listMiddleTtileColor;
    }

    public String getListMiddleTtile() {
        return listMiddleTtile;
    }

    public void setListMiddleTtile(String listMiddleTtile) {
        this.listMiddleTtile = listMiddleTtile;
    }

    public int getListMiddleTtileColor() {
        return listMiddleTtileColor;
    }

    public void setListMiddleTtileColor(int listMiddleTtileColor) {
        this.listMiddleTtileColor = listMiddleTtileColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.listMiddleTtile);
        dest.writeInt(this.listMiddleTtileColor);
    }

    protected ListMiddleListBean(Parcel in) {
        this.listMiddleTtile = in.readString();
        this.listMiddleTtileColor = in.readInt();
    }

    public static final Creator<ListMiddleListBean> CREATOR = new Creator<ListMiddleListBean>() {
        @Override
        public ListMiddleListBean createFromParcel(Parcel source) {
            return new ListMiddleListBean(source);
        }

        @Override
        public ListMiddleListBean[] newArray(int size) {
            return new ListMiddleListBean[size];
        }
    };
}