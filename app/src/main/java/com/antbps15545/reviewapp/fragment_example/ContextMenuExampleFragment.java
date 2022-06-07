package com.antbps15545.reviewapp.fragment_example;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.databinding.FragmentContextMenuExampleBinding;

public class ContextMenuExampleFragment extends Fragment {

    FragmentContextMenuExampleBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_context_menu_example, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("ContextMenu Example");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerForContextMenu(binding.button);
        registerForContextMenu(binding.button1);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(binding.button.isPressed()){
            getActivity().getMenuInflater().inflate(R.menu.context_menu, menu);
            menu.setHeaderTitle("Color");
        } else if(binding.button1.isPressed()) {
            menu.setHeaderTitle("Context Menu");
            MenuItem itemRed = menu.add(1,1,1, "Red");
            itemRed.setIcon(getResources().getDrawable(R.drawable.ic_baseline_color_lens_24));
            itemRed.getIcon().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_IN);
            MenuItem itemYellow = menu.add(1,1,1, "Yellow");
            itemYellow.setIcon(getResources().getDrawable(R.drawable.ic_baseline_color_lens_24));
            itemYellow.getIcon().setColorFilter(getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_IN);
            MenuItem itemBlue = menu.add(1,1,1, "Blue");
            itemBlue.setIcon(getResources().getDrawable(R.drawable.ic_baseline_color_lens_24));
            itemBlue.getIcon().setColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.SRC_IN);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.redColor:
                binding.layout.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case R.id.yellowColor:
                binding.layout.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;
            case R.id.blueColor:
                binding.layout.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case R.id.grayColor:
                binding.layout.setBackgroundColor(getResources().getColor(R.color.gray));
                break;
            case R.id.greenColor:
                binding.layout.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            default:
                binding.layout.setBackgroundColor(getResources().getColor(R.color.white));
                break;
        }
        return true;
    }
}