package com.test.abc.data.local;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FoodEntity.class}, version = 1)
public abstract class ABCDatabase extends RoomDatabase {
    private static volatile ABCDatabase INSTANCE;

    public static ABCDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ABCDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ABCDatabase.class, "ABC.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract FoodDAO foodDao();
}
