package com.pxz.pxzdialog.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 类说明：分享dialog列表的实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/21 15:15
 */
public class ShareListBean implements Parcelable {
    /**
     * 标题
     */
    private String shareTtile;
    /**
     * 标题颜色
     */
    private int shareTtileColor;
    /**
     * 图片
     */
    private int shareImg;

    public ShareListBean() {
    }

    public ShareListBean(String shareTtile, int shareTtileColor, int shareImg) {
        this.shareTtile = shareTtile;
        this.shareTtileColor = shareTtileColor;
        this.shareImg = shareImg;
    }

    public String getShareTtile() {
        return shareTtile;
    }

    public void setShareTtile(String shareTtile) {
        this.shareTtile = shareTtile;
    }

    public int getShareTtileColor() {
        return shareTtileColor;
    }

    public void setShareTtileColor(int shareTtileColor) {
        this.shareTtileColor = shareTtileColor;
    }

    public int getShareImg() {
        return shareImg;
    }

    public void setShareImg(int shareImg) {
        this.shareImg = shareImg;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.shareTtile);
        dest.writeInt(this.shareTtileColor);
        dest.writeInt(this.shareImg);
    }

    protected ShareListBean(Parcel in) {
        this.shareTtile = in.readString();
        this.shareTtileColor = in.readInt();
        this.shareImg = in.readInt();
    }

    public static final Creator<ShareListBean> CREATOR = new Creator<ShareListBean>() {
        @Override
        public ShareListBean createFromParcel(Parcel source) {
            return new ShareListBean(source);
        }

        @Override
        public ShareListBean[] newArray(int size) {
            return new ShareListBean[size];
        }
    };
}