package com.example.dinnernightv2.room;

import androidx.room.*;

import java.util.ArrayList;

@Entity(tableName = "recipe")
public class Recipe {
    @PrimaryKey
    public int id;

    public String image_id;

    public String name;

    public int cook_time_int;

    public String cook_time_unit;

    public int servings;

    public int calories;

    public String ingredients;

    public String directions;
}
