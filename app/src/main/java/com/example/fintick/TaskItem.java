package com.example.fintick;

// Simple model class for a Task
public class TaskItem {
    private String title;

    public TaskItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
