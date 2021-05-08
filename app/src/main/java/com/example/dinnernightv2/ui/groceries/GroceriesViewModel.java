package com.example.dinnernightv2.ui.groceries;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GroceriesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GroceriesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is groceries fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}