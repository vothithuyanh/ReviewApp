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
import com.antbps15545.reviewapp.fragment.ListPageFragment;
import com.antbps15545.reviewapp.models.Source;

import java.util.ArrayList;

public class ListLMSFragment extends Fragment {
    View view;
    RecyclerView rcv;
    ListLMSAdapter adapter;
    ArrayList<Source> list;
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
                loadFragment(position);
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
        list.add(new Source("TextView","https://vietjack.com/android/textview_trong_android.jsp","https://developer.android.com/reference/android/widget/TextView"));
        list.add(new Source("EditText","",""));
        list.add(new Source("TextInputEditText","https://openplanning.net/12691/android-textinputlayout","https://developer.android.com/reference/com/google/android/material/textfield/TextInputLayout"));
        list.add(new Source("Button","https://xuanthulab.net/button-trong-android.html","https://developer.android.com/reference/android/widget/Button"));
        list.add(new Source("ImageView","https://xuanthulab.net/imageview-va-imagebutton-trong-android.html","https://developer.android.com/reference/android/widget/ImageView"));
        list.add(new Source("CircleImageView","https://viblo.asia/p/tao-mot-circle-imageview-android-voi-thu-vien-hdodenhof-bWrZnLRY5xw","https://github.com/hdodenhof/CircleImageView"));
        list.add(new Source("DatePicker","https://openplanning.net/12619/android-datepicker","https://developer.android.com/reference/android/widget/DatePicker"));
        list.add(new Source("CheckBox","",""));
        list.add(new Source("ProgressBar","https://openplanning.net/12745/android-progressbar","https://developer.android.com/reference/android/widget/ProgressBar"));
        list.add(new Source("Spinner","",""));
        list.add(new Source("RadioButton","",""));
        list.add(new Source("ToggleButton","https://xuanthulab.net/togglebutton-trong-lap-trinh-android.html","https://developer.android.com/guide/topics/ui/controls/togglebutton#:~:text=A%20toggle%20button%20allows%20the,add%20with%20a%20Switch%20object."));
        list.add(new Source("AutoCompleteTextView","https://xuanthulab.net/radiobutton-va-radiogroup-trong-lap-trinh-android.html","https://developer.android.com/guide/topics/ui/controls/radiobutton"));
        list.add(new Source("Bottom Navigation","",""));
        list.add(new Source("MeowBottomNavigation","https://github.com/oneHamidreza/MeowBottomNavigation","https://developer.android.com/reference/com/google/android/material/bottomnavigation/BottomNavigationView"));
        list.add(new Source("DrawerLayout","https://viblo.asia/p/cach-tao-navigation-drawer-ByEZk0NElQ0","https://developer.android.com/guide/navigation/navigation-ui?gclid=CjwKCAjwtIaVBhBkEiwAsr7-c7CTir6Ya5BwyRcv_NcBxihbxE8rBEMTxviE0LE058cwKxssDH6WuxoCN14QAvD_BwE&gclsrc=aw.ds"));
        list.add(new Source("Switch","",""));
        list.add(new Source("CardView","https://openplanning.net/12701/android-cardview","https://developer.android.com/guide/topics/ui/layout/cardview"));
        list.add(new Source("SearchView","https://hiepsiit.com/detail/android/laptrinhandroid/searchview","https://developer.android.com/reference/android/widget/SearchView"));
        list.add(new Source("ListView","https://openplanning.net/10435/android-listview#a1302391","https://developer.android.com/reference/android/widget/ListView"));
        list.add(new Source("RecyclerView","https://vncoder.vn/bai-hoc/recyclerview-trong-android-96","https://developer.android.com/guide/topics/ui/layout/recyclerview"));
        list.add(new Source("ActionBar","https://xuanthulab.net/toolbar-actionbar-trong-lap-trinh-android.html","https://developer.android.com/reference/android/app/ActionBar"));
        list.add(new Source("OptionMenu","https://openplanning.net/12605/android-optionmenu","https://developer.android.com/guide/topics/ui/menus#options-menu"));
        list.add(new Source("ContextMenu","https://openplanning.net/12615/android-contextmenu","https://developer.android.com/guide/topics/ui/menus"));
        list.add(new Source("PopupMenu","https://openplanning.net/12631/android-popupmenu","https://developer.android.com/reference/android/widget/PopupMenu"));
        list.add(new Source("AlertDialog","https://openplanning.net/12629/android-alertdialog","https://developer.android.com/reference/android/app/AlertDialog"));
        list.add(new Source("ProgressDialog","",""));
        list.add(new Source("SnackBar","",""));
        list.add(new Source("FloatingButtonAction","https://openplanning.net/12705/android-floatingactionbutton","https://developer.android.com/guide/topics/ui/floating-action-button"));
        list.add(new Source("Toast","",""));
        list.add(new Source("RatingBar","https://openplanning.net/12623/android-ratingbar5","https://developer.android.com/reference/android/widget/RatingBar"));
        list.add(new Source("WebView","https://viblo.asia/p/tim-hieu-ve-webview-trong-android-Ljy5VPqzZra","https://developer.android.com/reference/android/webkit/WebView"));
        list.add(new Source("TabLayout","https://viblo.asia/p/tao-material-design-tab-trong-ung-dung-android-XL6lAP6NZek","https://developer.android.com/reference/com/google/android/material/tabs/TabLayout"));
        list.add(new Source("VideoView","https://openplanning.net/10487/android-videoview","https://developer.android.com/reference/android/widget/VideoView"));
    }

    public void loadFragment(int position){
//        try {
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("Source", list.get(position));
//            Log.d("_title",list.get(position).getTitle());
//            Fragment fragment = (Fragment)(Class.forName("com.antbps15545.reviewapp.fragment."+list.get(position).getTitle()+"Fragment").newInstance());
//            fragment.setArguments(bundle);
//            FragmentTransaction transaction = getFragmentManager().beginTransaction();
//            transaction.replace(R.id.main_content, fragment).commit();
//        }catch (Exception e){
//            Log.e("click_rcv","fragment not found");
//        }

        Bundle bundle = new Bundle();
        bundle.putSerializable("source", list.get(position));
        Fragment fragment = new ListPageFragment();
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.main_content, fragment).commit();
    }
}
