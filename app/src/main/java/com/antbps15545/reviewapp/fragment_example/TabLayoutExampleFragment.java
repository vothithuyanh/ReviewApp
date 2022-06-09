package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.databinding.FragmentTabLayoutExampleBinding;
import com.antbps15545.reviewapp.fragment.New1Fragment;
import com.antbps15545.reviewapp.fragment.New2Fragment;
import com.antbps15545.reviewapp.fragment.New3Fragment;
import com.google.android.material.tabs.TabLayout;

public class TabLayoutExampleFragment extends Fragment {
    FragmentTabLayoutExampleBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab_layout_example, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("TabLayout Example");
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PagerAdapter adapter = new PagerAdapter(getActivity().getSupportFragmentManager());
        binding.viewpager.setAdapter(adapter);
        binding.tabs.setupWithViewPager(binding.viewpager);
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if(i == 0){
                return new New1Fragment();
            }
            else if(i == 1){
                return new New2Fragment();
            }
            else if( i==2 )
            {
                return new New3Fragment();
            }
            else{
                return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0:
                    return "Tab 1";
                case 1:
                    return "Tab 2";
                case 2:
                    return "Tab 3";
            }
            return null;
        }
    }
}
