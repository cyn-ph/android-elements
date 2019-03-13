package com.test.abc.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.test.abc.beans.FoodDAO;

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

    public abstract FoodDAO userDao();
}
