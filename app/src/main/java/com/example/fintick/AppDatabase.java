package com.example.fintick;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Context;

import com.example.fintick.ListTask;
import com.example.fintick.ListTaskDao;

@Database(entities = {ListItem.class, ListTask.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract ListDao listDao();

    public abstract ListTaskDao listTaskDao();

//    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//
////             database.execSQL("ALTER TABLE your_table ADD COLUMN new_column TEXT");
//        }
//    };

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "fintick_database2"
                    ).
                    allowMainThreadQueries().
                    build(); // فقط برای تست
        }
        return instance;
    }
}
