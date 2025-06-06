package com.example.fintick;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    private List<TaskItem> tasks;
    private List<ListTask> ListTasks;

    public TasksAdapter(List<TaskItem> tasks) {
        this.tasks = tasks;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView taskTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.taskTitle);
        }
    }

    @NonNull
    @Override
    public TasksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksAdapter.ViewHolder holder, int position) {
        TaskItem task = tasks.get(position);
        holder.taskTitle.setText(task.getTitle());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
    @SuppressLint("NotifyDataSetChanged")
    public void setTasks(List<ListTask> tasks) {

        this.ListTasks = tasks;
        notifyDataSetChanged();
    }

}
