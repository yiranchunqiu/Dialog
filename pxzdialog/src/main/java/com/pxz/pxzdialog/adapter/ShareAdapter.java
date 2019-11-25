package com.pxz.pxzdialog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pxz.pxzdialog.R;
import com.pxz.pxzdialog.bean.ShareListBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 类说明：分享adapter
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/21 15:30
 */
public class ShareAdapter extends RecyclerView.Adapter<ShareAdapter.ViewHolder>{
    private Context context;
    private ArrayList<ShareListBean> shareListBeans;
    private AdapterOnClick adapterOnClick;

    public ShareAdapter(Context context, ArrayList<ShareListBean> shareListBeans) {
        this.context = context;
        this.shareListBeans = shareListBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_share, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ShareListBean shareListBean = shareListBeans.get(position);
        holder.ivItemImg.setImageResource(shareListBean.getShareImg());
        holder.tvItemTitle.setText(shareListBean.getShareTtile());
        holder.tvItemTitle.setTextColor(ContextCompat.getColor(context, shareListBean.getShareTtileColor()));
        //点击事件
        holder.llItem.setOnClickListener(view -> {
            if (adapterOnClick!=null) {
                adapterOnClick.onClick(shareListBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shareListBeans.size();
    }

    /**
     * 设置点击事件
     */
    public void setAdapterOnClick(AdapterOnClick adapterOnClick) {
        this.adapterOnClick = adapterOnClick;
    }

    public interface AdapterOnClick{
        /**
         * 点击事件
         */
        void  onClick(ShareListBean shareListBean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout llItem;
        private ImageView ivItemImg;
        private TextView tvItemTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            llItem = itemView.findViewById(R.id.ll_item);
            ivItemImg = itemView.findViewById(R.id.iv_item_img);
            tvItemTitle = itemView.findViewById(R.id.tv_item_title);
        }
    }
}