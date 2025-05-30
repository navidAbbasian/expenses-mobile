package com.example.fintick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListsAdapter extends RecyclerView.Adapter<ListsAdapter.ListViewHolder> {

    private List<String> itemList;

    // Constructor to receive data
    public ListsAdapter(List<String> itemList) {
        this.itemList = itemList;
    }

    // ViewHolder class
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView itemTitle;

        public ListViewHolder(View view) {
            super(view);
            itemTitle = view.findViewById(R.id.item_title);
        }
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        String title = itemList.get(position);
        holder.itemTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}