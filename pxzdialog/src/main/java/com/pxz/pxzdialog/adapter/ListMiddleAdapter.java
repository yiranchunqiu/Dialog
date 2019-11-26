package com.pxz.pxzdialog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pxz.pxzdialog.R;
import com.pxz.pxzdialog.bean.ListMiddleListBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 类说明：中间列表dialog的adapter
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/22 9:22
 */
public class ListMiddleAdapter extends RecyclerView.Adapter<ListMiddleAdapter.ViewHolder>{
    private Context context;
    private ArrayList<ListMiddleListBean> listMiddleListBeans;
    private AdapterOnClick adapterOnClick;

    public ListMiddleAdapter(Context context, ArrayList<ListMiddleListBean> listMiddleListBeans) {
        this.context = context;
        this.listMiddleListBeans = listMiddleListBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_middle, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ListMiddleListBean listMiddleListBean = listMiddleListBeans.get(position);
        holder.tvItemTitle.setText(listMiddleListBean.getListMiddleTtile());
        holder.tvItemTitle.setTextColor(ContextCompat.getColor(context, listMiddleListBean.getListMiddleTtileColor()));
        if (listMiddleListBeans.size()-1==position){
            holder.vItemLine.setVisibility(View.GONE);
        }else{
            holder.vItemLine.setVisibility(View.VISIBLE);
        }
        //点击事件
        holder.llItem.setOnClickListener(view -> {
            if (adapterOnClick!=null) {
                adapterOnClick.onClick(listMiddleListBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMiddleListBeans.size();
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
        void  onClick(ListMiddleListBean listMiddleListBean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout llItem;
        private TextView tvItemTitle;
        private View vItemLine;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            llItem = itemView.findViewById(R.id.ll_item);
            tvItemTitle = itemView.findViewById(R.id.tv_item_title);
            vItemLine=itemView.findViewById(R.id.v_item_line);
        }
    }
}