package com.antbps15545.reviewapp.fragment_example;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.databinding.FragmentActionBarExampleBinding;

public class ActionBarExampleFragment extends Fragment {
    FragmentActionBarExampleBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_action_bar_example, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("ActionBar Example");
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle("Action Bar");
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Action Bar");
        // Tạo logo
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.drawable.rating);
        //Lấy chiều cao của ActionBar
        TypedArray styledAttributes = getActivity().getTheme().obtainStyledAttributes(new int[] { android.R.attr.actionBarSize });
        int actionBarSize = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        //Tạo Drawable mới bằng cách thu/phóng
//        Drawable drawable= getResources().getDrawable(R.drawable.rating);
//        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
//        Drawable newdrawable = new BitmapDrawable(getResources(),
//                Bitmap.createScaledBitmap(bitmap, actionBarSize,  actionBarSize, true));
//        actionBar.setLogo(newdrawable);
        // change back icon
        Drawable drawable= getResources().getDrawable(R.drawable.back);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeAsUpIndicator(drawable);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.actionbar_menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Toast.makeText(getContext(), "Menu 1 Action Bar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(getContext(), "Menu 2 Action Bar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu3:
                Toast.makeText(getContext(), "Menu 3 Action Bar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu41:
                Toast.makeText(getContext(), "Menu 41 Action Bar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu42:
                Toast.makeText(getContext(), "Menu 42 Action Bar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu43:
                Toast.makeText(getContext(), "Menu 43 Action Bar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu5:
                Toast.makeText(getContext(), "Menu 5 Action Bar", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
