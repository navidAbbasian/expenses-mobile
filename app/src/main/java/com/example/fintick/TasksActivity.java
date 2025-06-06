package com.example.fintick;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TasksAdapter adapter;
    private ArrayList<TaskItem> taskList;
    private String listTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        // Get title of list from intent
        listTitle = getIntent().getStringExtra("list_title");

        TextView titleView = findViewById(R.id.textListTitle);
        titleView.setText("لیست: " + listTitle);

        recyclerView = findViewById(R.id.recyclerTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        taskList = new ArrayList<>();
        adapter = new TasksAdapter(taskList);
        recyclerView.setAdapter(adapter);

        // Test data
        taskList.add(new TaskItem("اولین تسک"));
        taskList.add(new TaskItem("دومین تسک"));
        adapter.notifyDataSetChanged();
    }
}
