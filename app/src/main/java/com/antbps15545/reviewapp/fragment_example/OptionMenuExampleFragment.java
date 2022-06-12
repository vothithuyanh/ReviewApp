package com.antbps15545.reviewapp.fragment_example;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;


import com.antbps15545.reviewapp.R;

public class OptionMenuExampleFragment extends Fragment {

    private static final String LOG_TAG= "OptionMenuExample";
    private SearchView searchView;
    Toolbar toolbar;
    private String lastQuery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_option_menu_example, container, false);
        toolbar = view.findViewById(R.id.toolBar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).setTitle("Option Menu");
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);

        // If you want Icon display in Overflow Menu.
        // https://stackoverflow.com/questions/19750635/icon-in-menu-not-showing-in-android
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
//
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        this.searchView = (SearchView) menu.findItem(R.id.menuItem_search).getActionView();
//
        this.searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        // Need click "search" icon to expand SearchView.
        this.searchView.setIconifiedByDefault(true);
//
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            // Typing search text.
            public boolean onQueryTextChange(String newText) {
                // This is your adapter that will be filtered
                Log.i(LOG_TAG, "onQueryTextChange: " + newText);
                return true;
            }

            // Press Enter to search (Or something to search).
            public boolean onQueryTextSubmit(String query) {
                // IMPORTANT!
                // Prevent onQueryTextSubmit() method called twice.
                // https://stackoverflow.com/questions/34207670
                searchView.clearFocus();

                Log.i(LOG_TAG, "onQueryTextSubmit: " + query);
                return doSearch(query);
            }
        });
//
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "SearchView.onSearchClickListener!" );
            }
        }) ;

        super.onCreateOptionsMenu(menu, inflater);
    }
//
    private boolean doSearch(String query) {
        if (query == null || query.isEmpty()) {
            return false; // Cancel search.
        }
        this.lastQuery = query;

        Toast.makeText(getContext(), "Search: " + query, Toast.LENGTH_LONG).show();
        return true;
    }
//
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem_open:
                Toast.makeText(getContext(), "Open ...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuItem_delete:
                Toast.makeText(getContext(), "Delete ...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuItem_facebook:
                Toast.makeText(getContext(), "Facebook Share ...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuItem_instagram:
                Toast.makeText(getContext(), "Instagram Share ...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuItem_settings:
                Toast.makeText(getContext(), "Settings ...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuItem_search:
                Log.i(LOG_TAG, "onOptionsItemSelected (R.id.menuItem_search)");
                Toast.makeText(getContext(), "Search ...", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}