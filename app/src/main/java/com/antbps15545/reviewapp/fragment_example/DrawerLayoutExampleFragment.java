package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.antbps15545.reviewapp.R;
import com.google.android.material.navigation.NavigationView;

public class DrawerLayoutExampleFragment extends Fragment {

    private DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar tool_bar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drawer_layout_example, container, false);
        tool_bar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(tool_bar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Drawer Example");
        mDrawerLayout = view.findViewById(R.id.drawer_layout);
        mDrawerLayout.openDrawer(GravityCompat.START);
        toggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, tool_bar, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_camera:
                        Toast.makeText(getContext(), "Import....", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_gallery:
                        Toast.makeText(getContext(), "Gallery....", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_slideshow:
                        Toast.makeText(getContext(), "Slideshow....", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_manage:
                        Toast.makeText(getContext(), "Manage....", Toast.LENGTH_SHORT).show();
                        break;
                }

                item.setChecked(true);

                mDrawerLayout.closeDrawers();

                return true;
            }
        });

        return view;

    }
}