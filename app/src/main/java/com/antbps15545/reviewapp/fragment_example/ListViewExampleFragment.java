package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.adapter.ListViewBaseAdapter;
import com.antbps15545.reviewapp.databinding.FragmentListViewExampleBinding;
import com.antbps15545.reviewapp.models.Country;
import com.antbps15545.reviewapp.models.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListViewExampleFragment extends Fragment {

    FragmentListViewExampleBinding binding;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_view_example, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("ListView Example");
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // ListView & ArrayAdapter
        UserAccount tom = new UserAccount("Tom","admin");
        UserAccount jerry = new UserAccount("Jerry","user");
        UserAccount donald = new UserAccount("Donald","guest", false);
        UserAccount[] users = new UserAccount[]{tom,jerry, donald};
        ArrayAdapter<UserAccount> arrayAdapter
                = new ArrayAdapter<UserAccount>(getContext(), android.R.layout.simple_list_item_1 , users);
        binding.lv1.setAdapter(arrayAdapter);

        //ListView & SimpleAdapter
        List<HashMap<String, Object>> ds = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> coun = new HashMap<String, Object>();
        coun.put("name", "Viet Nam");
        coun.put("flag", R.drawable.vn);
        coun.put("population", "97.34m");
        ds.add(coun);
        coun = new HashMap<String, Object>();
        coun.put("name", "Laos");
        coun.put("flag", R.drawable.laos);
        coun.put("population", "7.27m");
        ds.add(coun);
        coun = new HashMap<String, Object>();
        coun.put("name", "Cambodia");
        coun.put("flag", R.drawable.cam);
        coun.put("population", "16.72m");
        ds.add(coun);
        String[] from = {"name", "population", "flag"};
        int[] to = {R.id.namesimple, R.id.popusimple, R.id.flagsimple};
        SimpleAdapter adapter = new SimpleAdapter(getContext(), ds, R.layout.item_lv_ex_simple, from, to);
        binding.lv2.setAdapter(adapter);
        //ListView & BaseAdapter
        List<Country> list = new ArrayList<Country>();
        Country vietnam = new Country("Vietnam", "vn", 98000000);
        Country usa = new Country("United States", "us", 320000000);
        Country russia = new Country("Russia", "ru", 142000000);
        list.add(vietnam);
        list.add(usa);
        list.add(russia);
        binding.lv3.setAdapter(new ListViewBaseAdapter(getContext(), list));

        // When the user clicks on the ListItem
        binding.lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = binding.lv3.getItemAtPosition(position);
                Country country = (Country) o;
                Log.d("listview_ex_3","Selected :" + " " + country);
            }
        });
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        loadFragment(new ListPageFragment());
//        return super.onOptionsItemSelected(item);
//    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction transacion = getFragmentManager().beginTransaction();
        transacion.replace(R.id.main_content, fragment);
        transacion.addToBackStack(null);
        transacion.commit();
    }



}