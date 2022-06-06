package com.antbps15545.reviewapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.fragment_source.SourceFragment;
import com.antbps15545.reviewapp.models.Source;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.antbps15545.reviewapp.databinding.FragmentLmsPageBinding;

public class ListPageFragment extends Fragment {
    FragmentLmsPageBinding binding;
    Source rSource;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lms_page, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle!=null){
            rSource = (Source)bundle.getSerializable("source");
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(rSource.getTitle());
        }
        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.loadUrl(rSource.getLink());
        binding.botnav.setItemIconTintList(null);
        binding.botnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_vd:
                        loadExFragment();
                        break;
                    case R.id.nav_link:
                        loadFragment();
                        break;
                }
                return true;
            }
        });
    }

    private void loadFragment(){
        Bundle bundle = new Bundle();
        bundle.putSerializable("_source", rSource);
        Fragment fragment = new SourceFragment();
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.main_content, fragment).commit();
    }

    private void loadExFragment(){
        try {
            Log.d("_exampled","com.antbps15545.reviewapp.fragment_example."+rSource.getTitle().trim()+"ExampleFragment");
            Fragment fragment = (Fragment)(Class.forName("com.antbps15545.reviewapp.fragment_example."+rSource.getTitle().trim()+"ExampleFragment").newInstance());
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.addToBackStack(null);
            transaction.replace(R.id.main_content, fragment).commit();
        }catch (Exception e){
            Log.e("_exampleLoad","fragment not found");
        }
    }


}