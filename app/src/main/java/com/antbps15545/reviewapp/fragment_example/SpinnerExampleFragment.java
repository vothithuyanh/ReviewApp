package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.models.Employee;
import com.antbps15545.reviewapp.models.EmployeeDataUtils;


public class SpinnerExampleFragment extends Fragment {
    private Spinner spinnerEmployee;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_spinner_example, container, false);
        this.spinnerEmployee = (Spinner) view.findViewById(R.id.spinner_employee);

        Employee[] employees = EmployeeDataUtils.getEmployees();

        // (@resource) android.R.layout.simple_spinner_item:
        //   The resource ID for a layout file containing a TextView to use when instantiating views.
        //    (Layout for one ROW of Spinner)
        ArrayAdapter<Employee> adapter = new ArrayAdapter<Employee>(getContext(),
                android.R.layout.simple_spinner_item,
                employees);

        // Layout for All ROWs of Spinner.  (Optional for ArrayAdapter).
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.spinnerEmployee.setAdapter(adapter);

        // When user select a List-Item.
        this.spinnerEmployee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onItemSelectedHandler(parent, view, position, id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }
    private void onItemSelectedHandler(AdapterView<?> adapterView, View view, int position, long id) {
        Adapter adapter = adapterView.getAdapter();
        Employee employee = (Employee) adapter.getItem(position);

        Toast.makeText(getContext(), "Selected Employee: " + employee.getFullName() ,Toast.LENGTH_SHORT).show();
    }

}