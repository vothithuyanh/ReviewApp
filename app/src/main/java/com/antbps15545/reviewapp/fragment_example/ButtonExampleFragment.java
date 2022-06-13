package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.antbps15545.reviewapp.R;


public class ButtonExampleFragment extends Fragment {
    Button button;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_button_example, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Button button = view.findViewById(R.id.mybutton_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Muốn làm gì khi bấm vào Button thì
                //Viết code ở đây - Ví dụ:
                Toast.makeText(getContext(), "Hello!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}