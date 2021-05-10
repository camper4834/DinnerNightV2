package com.example.dinnernightv2.ui.recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.dinnernightv2.R;
import com.example.dinnernightv2.databinding.FragmentRecipesBinding;
import com.example.dinnernightv2.room.Recipe;

import java.util.ArrayList;

public class RecipesFragment extends Fragment {

    private RecipesViewModel recipesViewModel;
    private FragmentRecipesBinding binding;

    private NavController navController;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recipesViewModel =
                new ViewModelProvider(this).get(RecipesViewModel.class);

        binding = FragmentRecipesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}