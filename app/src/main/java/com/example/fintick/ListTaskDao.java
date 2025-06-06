package com.example.fintick;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.fintick.ListTask;

import java.util.List;

@Dao
public interface ListTaskDao {

    @Insert
    void insertTask(ListTask task);

    @Update
    void updateTask(ListTask task);

    @Delete
    void deleteTask(ListTask task);

    @Query("SELECT * FROM list_tasks WHERE list_id = :listId")
    List<ListTask> getTasksForList(int listId);

    @Query("DELETE FROM list_tasks WHERE list_id = :listId")
    void deleteTasksByListId(int listId);
    @Query("SELECT * FROM list_tasks WHERE list_id = :listId")
    List<ListTask> getTasksByListId(long listId);

}
