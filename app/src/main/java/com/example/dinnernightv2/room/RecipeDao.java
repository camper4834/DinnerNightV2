package com.example.dinnernightv2.room;

import androidx.room.*;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface RecipeDao {
    @Query("SELECT * FROM Recipe")
    List<Recipe> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(Recipe recipe);
}
