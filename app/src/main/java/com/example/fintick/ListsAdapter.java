package com.example.fintick;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ListsAdapter extends RecyclerView.Adapter<ListsAdapter.ViewHolder> {

    private List<ListItem> items;

    public ListsAdapter(List<ListItem> items) {
        this.items = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, date;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            date = itemView.findViewById(R.id.item_date);
        }
    }

    @NonNull
    @Override
    public ListsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ListsAdapter.ViewHolder holder, int position) {
        ListItem item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.date.setText("Created on: " + item.getDate());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
