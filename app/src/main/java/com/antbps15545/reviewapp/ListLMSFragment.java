package com.antbps15545.reviewapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.adapter.ListLMSAdapter;
import com.antbps15545.reviewapp.databinding.FragmentListLmsBinding;

import java.util.ArrayList;

public class ListLMSFragment extends Fragment {
    View view;
    RecyclerView rcv;
    ListLMSAdapter adapter;
    ArrayList<String> list;
    FragmentListLmsBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_lms, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("LMS");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();
        addList();
        ListLMSAdapter.OnItemTouchListener itemTouchListener = new ListLMSAdapter.OnItemTouchListener() {
            @Override
            public void onClick(View view, int position) {
                loadFragment(list.get(position));
            }
        };
        adapter = new ListLMSAdapter(getContext(), list, itemTouchListener);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.rcvListLMS.setLayoutManager(manager);
        binding.rcvListLMS.setAdapter(adapter);
        binding.searchBar.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
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
        list.add("ProgressBar");
        list.add("Spinner");
        list.add("RadioButton");
        list.add("ToogleButton");
        list.add("AutoCompleteTextView");
        list.add("Bottom Navigation");
        list.add("MeowBottomNavigation");
        list.add("DrawerLayout");
        list.add("Switch");
        list.add("CardView");
        list.add("SearchView");
        list.add("ListView");
        list.add("Recyclerview");
        list.add("ActionBar");
        list.add("Toolbar");
        list.add("OptionMenu");
        list.add("ContextMenu");
        list.add("PopupMenu");
        list.add("AlertDialog");
        list.add("ProgressDialog");
        list.add("SnackBar");
        list.add("FloatingButtonAction");
        list.add("Toast");
        list.add("RatingBar");
        list.add("WebView");
        list.add("TabLayout");
        list.add("VideoView");
    }

    public void loadFragment(String name){
        try {
            Fragment fragment = (Fragment)(Class.forName("com.antbps15545.reviewapp.fragment."+name+"Fragment").newInstance());
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.main_content, fragment).commit();
        }catch (Exception e){
            Log.e("click_rcv","fragment not found");
        }
    }
}
