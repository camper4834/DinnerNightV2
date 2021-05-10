package com.example.dinnernightv2.ui.recipes.items;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dinnernightv2.MainActivity;
import com.example.dinnernightv2.R;
import com.example.dinnernightv2.databinding.FragmentCajunBinding;
import com.example.dinnernightv2.databinding.FragmentRecipesBinding;
import com.example.dinnernightv2.room.Recipe;
import com.example.dinnernightv2.ui.recipes.RecipesViewModel;

import java.util.ArrayList;

public class CajunFragment extends Fragment {

    private FragmentCajunBinding binding;

    private NavController navController;

    private static final ArrayList<Recipe> badRecipeList;

    static {
        Recipe cajun = new Recipe();
        cajun.id = 0;
        cajun.image_id = R.drawable.cajun_shrimp_and_sausage;
        cajun.name = "Cajun Shrimp and Sausages";
        cajun.cook_time_unit = "1 Hour";
        cajun.servings = 4;
        cajun.calories = 300;
        cajun.ingredients = "• 1 pound frozen shrimp\n" +
                "• 9 ounces chicken sausage, sliced\n" +
                "• 2 TABLESPOONS olive oil\n" +
                "• 1 TABLESPOON unsalted butter\n" +
                "• 5 cloves garlic, pressed\n" +
                "• 1 red bell pepper, sliced\n" +
                "• 1/3 cup chicken stock\n" +
                "• 1 teaspoon salt and pepper\n" +
                "• 1 cup heavy cream\n" +
                "• 1/3 cup grated Parmesan\n" +
                "• (2 TABLESPOON Cajun Seasoning, optional)\n" +
                "• (1 small yellow onion, optional)\n" +
                "• (1 TABLESPOON fresh parsley, optional)";
        cajun.directions = "1. Put frozen shrimp in a colander and rinse for a minute. You want the shrimp to thaw a little before cooking. Then pat dry. The shrimp releases a lot of water and your dish could be soggy/watery if you don’t dry the shrimp.\n" +
                "2. In a large bowl, combine shrimp and sausage. Add olive oil and toss until coated. (You could add 2 TABLESPOONS cajun seasoning here as per the original recipe but Jess and I like it without).\n" +
                "3. Cook shrimp and sausage for about 10 minutes. The chicken and shrimp will release quite a bit of juices but cook until the juices reduce to about a TABLESPOON (As in, there should be barely any left). Remove the shrimp and sausage to a bowl.\n" +
                "4. In the same pan, melt butter in the remaining cooking juices. (Add onion and stir fry until translucent.) Add the bell peppers and fry for 2-3 minutes so they release their flavors. Then add garlic and cook until fragrant (about 30 seconds). Finally, deglaze the pan with the chicken broth, and allow the sauce to reduce down slightly (Make sure you scrape up all those good bits stuck to the pan from the sausage!).\n" +
                "5. Reduce heat to low, add the heavy cream, and bring to a gentle simmer, while stirring occasionally. Adjust seasoning with salt and pepper, to taste (Do not forget to salt here! Every dish needs to be salted and tasted in the middle of cooking and this is the point you do it in this dish!).\n" +
                "6. Add in the parmesan cheese. Allow the pepper cream sauce to simmer for a further minute until cheese melts through.\n" +
                "7. Add the grilled shrimp and sausage back into the skillet.";
        Recipe mississippi = new Recipe();
        mississippi.id = 1;
        mississippi.image_id = R.drawable.mississippi_chicken;
        mississippi.name = "Mississippi Chicken";
        mississippi.cook_time_unit = "3 Hours";
        mississippi.servings = 6;
        mississippi.calories = 500;
        mississippi.ingredients = "• 3 lb boneless chicken breast\n" +
                "• 1 pack Au Jus gravy mix\n" +
                "• 1 pack Ranch dressing mix\n" +
                "• 1 stick butter\n" +
                "• 12 pepperoncini peppers";
        mississippi.directions = "Throw everything into the crockpot and cook on low for 6-8 hours.";
        Recipe salisbury = new Recipe();
        salisbury.id = 2;
        salisbury.image_id = R.drawable.salisbury_steak;
        salisbury.name = "Salisbury Steak";
        salisbury.cook_time_unit = "3 Hours";
        salisbury.servings = 4;
        salisbury.calories = 400;
        salisbury.ingredients = "• 1 ½ lb ground beef\n" +
                "• 1 egg\n" +
                "• ½ cup bread crumbs\n" +
                "• 1 pack onion soup mix\n" +
                "• 1 can golden mushroom soup, undiluted";
        salisbury.directions = "1. Combine beef, egg, bread crumbs, and dry onion soup mix in large bowl. Form mixture evenly into four 1-inch thick patties\n" +
                "2. Heat large skillet over medium-high heat and cook patties 2 minutes each side until lightly browned\n" +
                "3. Remove patties from skillet and place in crockpot. Cover patties with mushroom soup and cook on low for 3 to 3 ½ hours.";
        Recipe pato = new Recipe();
        pato.id = 3;
        pato.image_id = R.drawable.chicken_el_pato;
        pato.name = "Chicken El Pato";
        pato.cook_time_unit = "6 Hours";
        pato.servings = 4;
        pato.calories = 400;
        pato.ingredients = "• 1 ½ lb boneless chicken breast\n" +
                "• 2 cans (15 oz) El Pato sauce\n" +
                "• 2 cups mexican blend cheese";
        pato.directions = "1. Cut chicken breasts in half. Do not cut them any smaller than that as you want big chunks to shred later.\n" +
                "2. Put the chicken and the el pato sauce in the crockpot and cook on low for 4-6 hours or on high for 3-5 hours.\n" +
                "3. 30 minutes before serving sprinkle the cheese on top and cook for the additional 30 minutes.";
        badRecipeList = new ArrayList<>();
        badRecipeList.add(cajun);
        badRecipeList.add(mississippi);
        badRecipeList.add(salisbury);
        badRecipeList.add(pato);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentCajunBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Bundle bundle = getArguments();
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        int id = bundle.getInt("id");
        Recipe thisRecipe = badRecipeList.get(id);
        binding.mainImage.setImageResource(thisRecipe.image_id);
        binding.recipeName.setText(thisRecipe.name);
        binding.cookTime.setText(thisRecipe.cook_time_unit);
        binding.servings.setText(Integer.toString(thisRecipe.servings));
        binding.calories.setText(Integer.toString(thisRecipe.calories));
        binding.ingredients.setText(thisRecipe.ingredients);
        binding.directions.setText(thisRecipe.directions);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(thisRecipe.name);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}