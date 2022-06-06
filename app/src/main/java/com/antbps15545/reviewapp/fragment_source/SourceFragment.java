package com.antbps15545.reviewapp.fragment_source;

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

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.databinding.FragmentListViewSourceBinding;
import com.antbps15545.reviewapp.models.Source;

public class SourceFragment extends Fragment {

    FragmentListViewSourceBinding binding;
    Source rSource;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_view_source, container, false);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle!=null){
            rSource = (Source)bundle.getSerializable("_source");
        }
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(rSource.getTitle());
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(rSource.getTitle()+" Source Android Studio");
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
        binding.wv.loadUrl(rSource.getS_link());
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