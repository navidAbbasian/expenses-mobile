package com.example.fintick;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;
import androidx.room.ColumnInfo;
import androidx.room.Index;

@Entity(
        tableName = "list_tasks",
        foreignKeys = @ForeignKey(
                entity = ListItem.class,
                parentColumns = "id",
                childColumns = "list_id",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index("list_id")}
)
public class ListTask {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "list_id")
    private int listId;

    private String title;

    @ColumnInfo(name = "is_done")
    private boolean isDone;

    // Constructor
    public ListTask(int listId, String title, boolean isDone) {
        this.listId = listId;
        this.title = title;
        this.isDone = isDone;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
