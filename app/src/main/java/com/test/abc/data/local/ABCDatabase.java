package com.test.abc.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FoodEntity.class}, version = 1)
public abstract class ABCDatabase extends RoomDatabase {

    public abstract FoodDAO foodDao();

}
