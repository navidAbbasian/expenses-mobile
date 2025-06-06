package com.example.fintick;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ListsAdapter extends RecyclerView.Adapter<ListsAdapter.ViewHolder> {

    private List<ListItem> items;
    private Context context;


    public ListsAdapter(Context context, List<ListItem> items) {
        this.context = context;
        this.items = items;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, date, type;
        ImageView iconType;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            date = itemView.findViewById(R.id.item_date);
            iconType = itemView.findViewById(R.id.icon_type);
            type = itemView.findViewById(R.id.item_type);

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
        holder.type.setText("Type: " + item.getType());

        // Show checklist icon if it's a TODO type
        if ("todo".equals(item.getType())) {
            holder.iconType.setVisibility(View.VISIBLE);
        } else {
            holder.iconType.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, TasksActivity.class);
            intent.putExtra("list_title", items.get(position).getTitle());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
