package com.example.dinnernightv2;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.dinnernightv2.room.AppDatabase;
import com.example.dinnernightv2.room.Recipe;
import com.example.dinnernightv2.room.RecipeDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class SimpleEntityReadWriteTest {
    private RecipeDao recipeDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        recipeDao = db.recipeDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeRecipeAndReadInList() throws Exception {
        Recipe recipe = creatRecipe();
        recipeDao.insert(recipe);
        List<Recipe> result = recipeDao.getAll();
        assertThat(result.get(0), equalTo(recipe));
    }

    Recipe creatRecipe() {
        Recipe recipe = new Recipe();
        recipe.id = 0;
        return recipe;
    }
}