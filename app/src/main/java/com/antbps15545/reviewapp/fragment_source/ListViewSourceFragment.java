package com.antbps15545.reviewapp.fragment_source;

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
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.databinding.FragmentListViewBinding;
import com.antbps15545.reviewapp.databinding.FragmentListViewSourceBinding;
import com.antbps15545.reviewapp.fragment.ListViewFragment;

public class ListViewSourceFragment extends Fragment {

    FragmentListViewSourceBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_view_source, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("ListView Source Android Studio");
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String url = "https://developer.android.com/reference/android/widget/ListView";
        binding.wv.getSettings().setJavaScriptEnabled(true);
//        binding.wv.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                //url will be the url that you click in your webview.
//                //you can open it with your own webview or do
//                //whatever you want
//
//                //Here is the example that you open it your own webview.
//                view.loadUrl(url);
//                return true;
//            }
//        });
        binding.wv.loadUrl(url);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        loadFragment(new ListViewFragment());
//        return super.onOptionsItemSelected(item);
//    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction transacion = getFragmentManager().beginTransaction();
        transacion.replace(R.id.main_content, fragment);
        transacion.addToBackStack(null);
        transacion.commit();
    }
}