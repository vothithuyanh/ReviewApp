package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.antbps15545.reviewapp.R;


public class CheckBoxExampleFragment extends Fragment {
    private CheckBox checkBoxCheckAll;
    private CheckBox checkBoxCcpp;
    private CheckBox checkBoxCsharp;
    private CheckBox checkBoxJava;

    private Button buttonShowResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_box_example, container, false);

        this.checkBoxCheckAll = (CheckBox) view.findViewById(R.id.checkBox_checkAll);
        this.checkBoxCcpp = (CheckBox) view.findViewById(R.id.checkBox_ccpp);
        this.checkBoxCsharp = (CheckBox) view.findViewById(R.id.checkBox_csharp);
        this.checkBoxJava = (CheckBox) view.findViewById(R.id.checkBox_java);

        this.buttonShowResult = (Button) view.findViewById(R.id.button_showResult);

        this.buttonShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });

        this.checkBoxCheckAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkAllCheckedChange(isChecked);
            }
        });


        return view;
    }
    private void showResult()  {
        String message = null;
        if(this.checkBoxCcpp.isChecked()) {
            message =  this.checkBoxCcpp.getText().toString();
        }
        if(this.checkBoxCsharp.isChecked()) {
            if(message== null)  {
                message =  this.checkBoxCsharp.getText().toString();
            } else {
                message += ", " + this.checkBoxCsharp.getText().toString();
            }
        }
        if(this.checkBoxJava.isChecked()) {
            if(message== null)  {
                message =  this.checkBoxJava.getText().toString();
            } else {
                message += ", " + this.checkBoxJava.getText().toString();
            }
        }
        message = message == null? "You select nothing": "You select: " + message;
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    // When "Check All" change state.
    private void checkAllCheckedChange(boolean isChecked) {
        this.checkBoxCsharp.setChecked(isChecked);
        this.checkBoxCcpp.setChecked(isChecked);
        this.checkBoxJava.setChecked(isChecked);
    }

    }