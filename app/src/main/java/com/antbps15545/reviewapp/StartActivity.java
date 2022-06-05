package com.antbps15545.reviewapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class StartActivity extends AppCompatActivity {
    private Toolbar mActionBarToolbar;
    public NavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getActionBarToolbar();
        DrawerLayout drawer = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, mActionBarToolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.addDrawerListener(toggle);
        loadFragment(new HomeFragment());
        toggle.syncState();
        navView.getMenu().getItem(0).setChecked(true);
        navView.setItemIconTintList(null);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment fragment = new Fragment();
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_android:
                        fragment = new StudioFragment();
                        break;
                    case R.id.nav_lms:
                        Toast.makeText(StartActivity.this, "Lms", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_about:
                        Toast.makeText(StartActivity.this, "About App", Toast.LENGTH_SHORT).show();
                        break;
                }
                item.setChecked(true);
                setTitle(item.getTitle());
                loadFragment(fragment);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.myToolbar);
            if (mActionBarToolbar != null) {
                setSupportActionBar(mActionBarToolbar);
            }
        }
        return mActionBarToolbar;
    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content, fragment).commit();
    }
}