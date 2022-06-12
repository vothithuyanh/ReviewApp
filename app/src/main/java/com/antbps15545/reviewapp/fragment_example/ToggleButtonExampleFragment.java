package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.antbps15545.reviewapp.R;

public class ToggleButtonExampleFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_toggle_button_example, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ToggleButton toggleButton1 = view.findViewById(R.id.toggle1);
        ToggleButton toggleButton2 = view.findViewById(R.id.toggle2);

        toggleButton1.setChecked(false);
        toggleButton2.setChecked(true);

        CompoundButton.OnCheckedChangeListener listener =
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        switch (compoundButton.getId()) {
                            case R.id.toggle1:
                                Toast.makeText(getContext(), "Nút 1:"
                                                + compoundButton.isChecked(),
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.toggle2:
                                Toast.makeText(getContext(), "Nút 2:"
                                                + compoundButton.isChecked(),
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                };

        toggleButton1.setOnCheckedChangeListener(listener);
        toggleButton2.setOnCheckedChangeListener(listener);
    }
}