package com.example.nhanvien2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nhanvien2.Item;
import com.example.nhanvien2.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.HomeViewHolder> {
    private List<Item> list;
    private ItemListener itemListener;

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public RecycleViewAdapter() {
        list=new ArrayList<>();
    }

    public RecycleViewAdapter(List<Item> list) {
        this.list = list;
    }

    public void setList(List<Item> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public Item getItem(int position){
        return list.get(position);
    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Item item= list.get(position);
        holder.tvten.setText(item.getTen());
        holder.tvnoidung.setText(item.getNoidung());
        holder.tvngayht.setText(item.getNgayht());
        holder.tvtt.setText(item.getTt());
        holder.tvct.setText(item.getCt());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvten,tvnoidung,tvngayht,tvtt,tvct;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            tvten=view.findViewById(R.id.tvten);
            tvnoidung=view.findViewById(R.id.tvnoidung);
            tvngayht=view.findViewById(R.id.tvngayht);
            tvtt=view.findViewById(R.id.tvtt);
            tvct=view.findViewById(R.id.tvct);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemListener != null){
                itemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public interface ItemListener{
        void onItemClick(View view,int position);
    }
}
