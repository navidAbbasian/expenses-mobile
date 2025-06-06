package com.example.fintick;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fintick.R;
import com.example.fintick.AppDatabase;
import com.example.fintick.ListTask;

import java.util.List;

public class TasksFragment extends Fragment {

    private int listId;
    private AppDatabase db;
    private RecyclerView recyclerView;
    private TasksAdapter adapter;
    private List<TaskItem> taskItem;

    public TasksFragment(int listId, AppDatabase db) {
        this.listId = listId;
        this.db = db;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        recyclerView = view.findViewById(R.id.tasksRecyclerView);
        EditText editText = view.findViewById(R.id.editTaskText);
        Button button = view.findViewById(R.id.btnAddTask);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new TasksAdapter(taskItem);
        recyclerView.setAdapter(adapter);

        loadTasks();

        button.setOnClickListener(v -> {
            String taskText = editText.getText().toString().trim();
            if (!taskText.isEmpty()) {
                ListTask task = new ListTask(listId, taskText, false);
                db.listTaskDao().insertTask(task);
                editText.setText("");
                loadTasks();
            }
        });

        return view;
    }

    private void loadTasks() {
        List<ListTask> tasks = db.listTaskDao().getTasksByListId(listId);
        adapter.setTasks(tasks);
    }
}
