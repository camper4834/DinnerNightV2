package com.example.dinnernightv2.room;

import androidx.room.*;

import java.util.List;

@Dao
public interface RecipeDao {
    @Query("SELECT * FROM Recipe")
    List<Recipe> getAll();
}
