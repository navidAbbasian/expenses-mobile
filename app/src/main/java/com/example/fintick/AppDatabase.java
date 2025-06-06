package com.example.fintick;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;

import com.example.fintick.ListTask;
import com.example.fintick.ListTaskDao;

@Database(entities = {ListItem.class, ListTask.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract ListDao listDao();
    public abstract ListTaskDao listTaskDao();


    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "fintick_database"
            ).allowMainThreadQueries().build(); // فقط برای تست
        }
        return instance;
    }
}
