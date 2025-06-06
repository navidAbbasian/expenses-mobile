package com.example.fintick;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ListDao {
    @Insert
    void insertList(ListItem listItem);

    @Query("SELECT * FROM lists")
    List<ListItem> getAllLists();
}
