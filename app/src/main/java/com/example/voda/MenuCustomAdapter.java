package com.example.voda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuCustomAdapter extends RecyclerView.Adapter<MenuCustomAdapter.ViewHolder> {

    Context context;
    ArrayList<MenuItem> items;

    public MenuCustomAdapter(Context context, ArrayList<MenuItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MenuCustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuCustomAdapter.ViewHolder holder, int position) {
        MenuItem item = items.get(position);
        //uri로 글라이더 이용해서 horder.menuPrice 에 이미지 넣기
        holder.menuName.setText(item.getName());
        holder.menuPrice.setText(String.valueOf(item.getPrice()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView menuImage;
        TextView menuName;
        TextView menuPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            menuImage = itemView.findViewById(R.id.iv_menuItem);
            menuName = itemView.findViewById(R.id.tv_menuName);
            menuPrice = itemView.findViewById(R.id.tv_menuPrice);

        }
    }
}
