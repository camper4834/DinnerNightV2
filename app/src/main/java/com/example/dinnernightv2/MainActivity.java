package com.example.dinnernightv2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.dinnernightv2.room.AppDatabase;
import com.example.dinnernightv2.room.Recipe;
import com.example.dinnernightv2.room.RecipeDao;
import com.facebook.stetho.Stetho;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import com.example.dinnernightv2.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_recipes, R.id.navigation_calendar, R.id.navigation_groceries, R.id.navigation_alarms, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        int theme = getThemeFromPreferences();
        setCurrentTheme(theme);

//        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, "dinner_night_database").build();
//        RecipeDao recipeDao = db.recipeDao();
//        List<Recipe> recipes = recipeDao.getAll();
    }

    public void setCurrentTheme(int theme) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("theme", theme);
        editor.apply();
        AppCompatDelegate.setDefaultNightMode(theme);
    }

    public int getThemeFromPreferences() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        int theme = sharedPref.getInt("theme", AppCompatDelegate.MODE_NIGHT_NO);
        return theme;
    }

    public int getCurrentTheme() {
        return AppCompatDelegate.getDefaultNightMode();
    }

}