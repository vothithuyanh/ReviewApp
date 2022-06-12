package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.antbps15545.reviewapp.R;

import java.util.Calendar;

public class DatePickerExampleFragment extends Fragment {

    private DatePicker datePicker;
    private EditText editTextDate;
    private Button buttonDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_date_picker_example, container, false);

        this.editTextDate = (EditText) view.findViewById(R.id.editText_date);
        this.buttonDate = (Button) view.findViewById(R.id.button_date);
        this.datePicker = (DatePicker) view.findViewById(R.id.datePicker);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month  = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        this.datePicker.init( year, month , day , new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                datePickerChange(  datePicker,   year,   month,   dayOfMonth);
            }
        });

        this.buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
            }
        });

        return view;

    }

    private void datePickerChange(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);
        this.editTextDate.setText(dayOfMonth +"-" + (month + 1) + "-" + year);
    }

    private void showDate()  {
        int year = this.datePicker.getYear();
        int month = this.datePicker.getMonth(); // 0 - 11
        int day = this.datePicker.getDayOfMonth();

        Toast.makeText(getContext(), "Date: " + day+"-"+ (month + 1) +"-"+ year, Toast.LENGTH_LONG).show();
    }
}