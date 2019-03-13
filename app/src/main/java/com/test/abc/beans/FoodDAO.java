package com.test.abc.beans;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.test.abc.data.FoodEntity;
import io.reactivex.Completable;
import io.reactivex.Single;

import java.util.List;

@Dao
public interface FoodDAO {

    /**
     * Get food from the table.
     */
    @Query("SELECT * FROM Food")
    Single<List<FoodEntity>> getAll();

    /**
     * Insert food in the database. If the user already exists, replace it.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertFood(FoodEntity food);

}
