package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 类说明：底部列表dialog的列表实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/21 17:40
 */
public class ListBottomListBean implements Parcelable {
    private String listBottomTtile;
    private int listBottomTtileColor;

    public ListBottomListBean() {
    }

    public ListBottomListBean(String listBottomTtile, int listBottomTtileColor) {
        this.listBottomTtile = listBottomTtile;
        this.listBottomTtileColor = listBottomTtileColor;
    }

    public String getListBottomTtile() {
        return listBottomTtile;
    }

    public void setListBottomTtile(String listBottomTtile) {
        this.listBottomTtile = listBottomTtile;
    }

    public int getListBottomTtileColor() {
        return listBottomTtileColor;
    }

    public void setListBottomTtileColor(int listBottomTtileColor) {
        this.listBottomTtileColor = listBottomTtileColor;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.listBottomTtile);
        dest.writeInt(this.listBottomTtileColor);
    }

    protected ListBottomListBean(Parcel in) {
        this.listBottomTtile = in.readString();
        this.listBottomTtileColor = in.readInt();
    }

    public static final Creator<ListBottomListBean> CREATOR = new Creator<ListBottomListBean>() {
        @Override
        public ListBottomListBean createFromParcel(Parcel source) {
            return new ListBottomListBean(source);
        }

        @Override
        public ListBottomListBean[] newArray(int size) {
            return new ListBottomListBean[size];
        }
    };
}