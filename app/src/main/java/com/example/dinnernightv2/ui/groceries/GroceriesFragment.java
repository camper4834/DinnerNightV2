package com.example.dinnernightv2.ui.groceries;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
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

import com.example.dinnernightv2.R;
import com.example.dinnernightv2.databinding.FragmentGroceriesBinding;

public class GroceriesFragment extends Fragment {

    private GroceriesViewModel groceriesViewModel;
    private FragmentGroceriesBinding binding;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        groceriesViewModel =
                new ViewModelProvider(this).get(GroceriesViewModel.class);

        binding = FragmentGroceriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        binding.checkBox1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                editor.putBoolean("checkState1", true);
                binding.checkBox1.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
            else {
                editor.putBoolean("checkState1", false);
                binding.checkBox1.setPaintFlags(~Paint.STRIKE_THRU_TEXT_FLAG);
            }
            editor.apply();
        });
        if(sharedPref.getBoolean("checkState1", false)) {
            binding.checkBox1.setChecked(true);
            binding.checkBox1.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

        binding.checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                editor.putBoolean("checkState2", true);
                binding.checkBox2.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
            else {
                editor.putBoolean("checkState2", false);
                binding.checkBox2.setPaintFlags(~Paint.STRIKE_THRU_TEXT_FLAG);
            }
            editor.apply();
        });
        if(sharedPref.getBoolean("checkState2", false)) {
            binding.checkBox2.setChecked(true);
            binding.checkBox2.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

        binding.checkBox3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                editor.putBoolean("checkState3", true);
                binding.checkBox3.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
            else {
                editor.putBoolean("checkState3", false);
                binding.checkBox3.setPaintFlags(~Paint.STRIKE_THRU_TEXT_FLAG);
            }
            editor.apply();
        });
        if(sharedPref.getBoolean("checkState3", false)) {
            binding.checkBox3.setChecked(true);
            binding.checkBox3.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
        
        binding.checkBox4.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                editor.putBoolean("checkState4", true);
                binding.checkBox4.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
            else {
                editor.putBoolean("checkState4", false);
                binding.checkBox4.setPaintFlags(~Paint.STRIKE_THRU_TEXT_FLAG);
            }
            editor.apply();
        });
        if(sharedPref.getBoolean("checkState4", false)) {
            binding.checkBox4.setChecked(true);
            binding.checkBox4.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

        binding.checkBox5.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                editor.putBoolean("checkState5", true);
                binding.checkBox5.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
            else {
                editor.putBoolean("checkState5", false);
                binding.checkBox5.setPaintFlags(~Paint.STRIKE_THRU_TEXT_FLAG);
            }
            editor.apply();
        });
        if(sharedPref.getBoolean("checkState5", false)) {
            binding.checkBox5.setChecked(true);
            binding.checkBox5.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

        binding.checkBox6.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                editor.putBoolean("checkState6", true);
                binding.checkBox6.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
            else {
                editor.putBoolean("checkState6", false);
                binding.checkBox6.setPaintFlags(~Paint.STRIKE_THRU_TEXT_FLAG);
            }
            editor.apply();
        });
        if(sharedPref.getBoolean("checkState6", false)) {
            binding.checkBox6.setChecked(true);
            binding.checkBox6.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}