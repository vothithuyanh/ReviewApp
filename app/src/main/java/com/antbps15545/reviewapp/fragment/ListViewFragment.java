package com.antbps15545.reviewapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.databinding.FragmentListViewBinding;
import com.antbps15545.reviewapp.fragment_example.ListviewExampleFragment;
import com.antbps15545.reviewapp.fragment_source.ListViewSourceFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ListViewFragment extends Fragment {
    FragmentListViewBinding binding;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_view, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("ListView");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.loadUrl("https://openplanning.net/10435/android-listview#a1302391");
        binding.botnav.setItemIconTintList(null);
        binding.botnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_vd:
                        loadFragment(new ListviewExampleFragment());
                        break;
                    case R.id.nav_link:
                        loadFragment(new ListViewSourceFragment());
                        break;
                }
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction transacion = getFragmentManager().beginTransaction();
        transacion.replace(R.id.main_content, fragment);
        transacion.addToBackStack(null);
        transacion.commit();
    }
}