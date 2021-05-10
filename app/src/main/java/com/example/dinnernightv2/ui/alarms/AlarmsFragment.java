package com.example.dinnernightv2.ui.alarms;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dinnernightv2.R;
import com.example.dinnernightv2.databinding.FragmentAlarmsBinding;

public class AlarmsFragment extends Fragment {

    private AlarmsViewModel alarmsViewModel;
    private FragmentAlarmsBinding binding;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        alarmsViewModel =
                new ViewModelProvider(this).get(AlarmsViewModel.class);

        binding = FragmentAlarmsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        binding.switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                editor.putBoolean("switchState1", true);
                binding.alarmOnText1.setText(R.string.alarm_on);
                binding.alarmOnText1.setTextAppearance(R.style.alarm_on);
            }
            else {
                editor.putBoolean("switchState1", false);
                binding.alarmOnText1.setText(R.string.alarm_off);
                binding.alarmOnText1.setTextAppearance(R.style.alarm_off);
            }
            editor.apply();
        });

        binding.switch2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                editor.putBoolean("switchState2", true);
                binding.alarmOnText2.setText(R.string.alarm_on);
                binding.alarmOnText2.setTextAppearance(R.style.alarm_on);
            }
            else {
                editor.putBoolean("switchState2", false);
                binding.alarmOnText2.setText(R.string.alarm_off);
                binding.alarmOnText2.setTextAppearance(R.style.alarm_off);
            }
            editor.apply();
        });

        binding.switch3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                editor.putBoolean("switchState3", true);
                binding.alarmOnText3.setText(R.string.alarm_on);
                binding.alarmOnText3.setTextAppearance(R.style.alarm_on);
            }
            else {
                editor.putBoolean("switchState3", false);
                binding.alarmOnText3.setText(R.string.alarm_off);
                binding.alarmOnText3.setTextAppearance(R.style.alarm_off);
            }
            editor.apply();
        });

        if(sharedPref.getBoolean("switchState1", false)) {
            binding.switch1.setChecked(true);
            binding.alarmOnText1.setText(R.string.alarm_on);
            binding.alarmOnText1.setTextAppearance(R.style.alarm_on);
        }
        if(sharedPref.getBoolean("switchState2", false)) {
            binding.switch2.setChecked(true);
            binding.alarmOnText2.setText(R.string.alarm_on);
            binding.alarmOnText2.setTextAppearance(R.style.alarm_on);
        }
        if(sharedPref.getBoolean("switchState3", false)) {
            binding.switch3.setChecked(true);
            binding.alarmOnText3.setText(R.string.alarm_on);
            binding.alarmOnText3.setTextAppearance(R.style.alarm_on);
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}