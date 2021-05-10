package com.example.dinnernightv2.ui.groceries;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dinnernightv2.R;

public class GroceryDateDialog extends DialogFragment {

    public GroceryDateDialog() {
        // Required empty public constructor
    }

    public static GroceryDateDialog newInstance(String param1, String param2) {
        GroceryDateDialog fragment = new GroceryDateDialog();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grocery_date_dialog, container, false);
    }
}