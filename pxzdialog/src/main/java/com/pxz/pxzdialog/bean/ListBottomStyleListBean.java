package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 类说明：底部列表带样式的dialog的列表实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/22 15:21
 */
public class ListBottomStyleListBean implements Parcelable {
    private String listBottomTtile;
    private int listBottomTtileColor;

    public ListBottomStyleListBean() {
    }

    public ListBottomStyleListBean(String listBottomTtile, int listBottomTtileColor) {
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

    protected ListBottomStyleListBean(Parcel in) {
        this.listBottomTtile = in.readString();
        this.listBottomTtileColor = in.readInt();
    }

    public static final Creator<ListBottomStyleListBean> CREATOR = new Creator<ListBottomStyleListBean>() {
        @Override
        public ListBottomStyleListBean createFromParcel(Parcel source) {
            return new ListBottomStyleListBean(source);
        }

        @Override
        public ListBottomStyleListBean[] newArray(int size) {
            return new ListBottomStyleListBean[size];
        }
    };
}