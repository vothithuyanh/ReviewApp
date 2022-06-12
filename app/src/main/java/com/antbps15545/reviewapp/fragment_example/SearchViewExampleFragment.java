package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.adapter.ListSearchViewAdapter;
import com.antbps15545.reviewapp.models.AnimalNames;

import java.util.ArrayList;

public class SearchViewExampleFragment extends Fragment {

    ListView list;
    ListSearchViewAdapter adapter;
    SearchView editsearch;
    String[] animalNameList;
    ArrayList<AnimalNames> arraylist = new ArrayList<AnimalNames>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_view_example, container, false);

        animalNameList = new String[]{"Lion", "Tiger", "Dog",
                "Cat", "Tortoise", "Rat", "Elephant", "Fox",
                "Cow","Donkey","Monkey","Dinosaur","Bear","Hippopotamus","Chimpanzee","Giraffe",
                "Jaguar","Racoon","Rhinoceros","Dolphin","Turtle","Swordfish","Eel","Walrus",
                "Squirrel","Porcupine","Bat","Deer","Alligator","Hermit crab","Penguin",
                "Thanh Tân đi vịn","Thúy Em chấp hết",""};

        // Locate the ListView in listview_main.xml
        list = (ListView) view.findViewById(R.id.listview);

        for (int i = 0; i < animalNameList.length; i++) {
            AnimalNames animalNames = new AnimalNames(animalNameList[i]);
            // Binds all strings into an array
            arraylist.add(animalNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListSearchViewAdapter(getContext(), arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) view.findViewById(R.id.search);
        editsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text = newText;
                adapter.filter(text);
                return false;
            }
        });

        return view;

    }

}