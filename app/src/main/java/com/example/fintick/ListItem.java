package com.example.fintick;

public class ListItem {
    private String title;
    private String date;

    public ListItem(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}
