package com.example.fintick;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lists")
public class ListItem {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String title;
    private String date;
    private String type;

    public ListItem(String title, String date, String type) {
        this.title = title;
        this.date = date;
        this.type = type;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }
}
