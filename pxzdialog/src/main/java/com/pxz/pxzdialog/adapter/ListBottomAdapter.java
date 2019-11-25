package com.pxz.pxzdialog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pxz.pxzdialog.R;
import com.pxz.pxzdialog.bean.ListBottomListBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 类说明：底部列表dialog的adapter
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/22 9:21
 */
public class ListBottomAdapter extends RecyclerView.Adapter<ListBottomAdapter.ViewHolder>{
    private Context context;
    private ArrayList<ListBottomListBean> listBottomListBeans;
    private AdapterOnClick adapterOnClick;

    public ListBottomAdapter(Context context, ArrayList<ListBottomListBean> listBottomListBeans) {
        this.context = context;
        this.listBottomListBeans = listBottomListBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_bottom, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ListBottomListBean listBottomListBean = listBottomListBeans.get(position);
        holder.tvItemTitle.setText(listBottomListBean.getListBottomTtile());
        holder.tvItemTitle.setTextColor(ContextCompat.getColor(context, listBottomListBean.getListBottomTtileColor()));
        //点击事件
        holder.llItem.setOnClickListener(view -> {
            if (adapterOnClick!=null) {
                adapterOnClick.onClick(listBottomListBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBottomListBeans.size();
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
        void  onClick(ListBottomListBean listBottomListBean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout llItem;
        private TextView tvItemTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            llItem = itemView.findViewById(R.id.ll_item);
            tvItemTitle = itemView.findViewById(R.id.tv_item_title);
        }
    }
}