package com.antbps15545.reviewapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListLMSFragment extends Fragment {
    View view;
    RecyclerView rcv;
    ListLMSAdapter adapter;
    ArrayList<String> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_lms, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcv = view.findViewById(R.id.rcvListLMS);
        list = new ArrayList<>();
        addList();
        adapter = new ListLMSAdapter(getContext(), list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(manager);
        rcv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void addList(){
        list.add("TextView");
        list.add("EditText");
        list.add("TextInputEditText");
        list.add("Button");
        list.add("ImageView");
        list.add("CircleImageView");
        list.add("DatePicker");
        list.add("CheckBox");
        list.add("Progress Bar");
        list.add("Spinner");
        list.add("Radio Button");
        list.add("Toogle Button");
        list.add("AutoComplete TextView");
        list.add("Bottom Navigation");
        list.add("Meow Bottom Navigation");
        list.add("Drawer Layout");
        list.add("Switch");
        list.add("CardView");
        list.add("SearchView");
        list.add("ListView");
        list.add("Recyclerview");
        list.add("Action Bar");
        list.add("Toolbar");
        list.add("Option Menu");
        list.add("Context Menu");
        list.add("Popup Menu");
        list.add("Alert Dialog");
        list.add("Progress Dialog");
        list.add("Snack Bar");
        list.add("Floating Button Action");
        list.add("Toast");
    }
}
