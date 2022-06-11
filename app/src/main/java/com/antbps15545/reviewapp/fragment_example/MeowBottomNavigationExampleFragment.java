package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.databinding.FragmentMeowNavigationExampleBinding;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MeowBottomNavigationExampleFragment extends Fragment {
    FragmentMeowNavigationExampleBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_meow_navigation_example, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("MeowBottomNavigation Example");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.meowNav.add(new MeowBottomNavigation.Model(1,R.drawable.face));
        binding.meowNav.add(new MeowBottomNavigation.Model(2,R.drawable.insta));
        binding.meowNav.add(new MeowBottomNavigation.Model(3,R.drawable.tik));
        binding.meowNav.add(new MeowBottomNavigation.Model(4,R.drawable.twit));
        binding.meowNav.add(new MeowBottomNavigation.Model(5,R.drawable.yout));
        binding.meowNav.show(2,false);
        binding.meowNav.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        Toast.makeText(getContext(), "Open FaceBook", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getContext(), "Open Instagram", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getContext(), "Open Tiktok", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getContext(), "Open Twitter", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getContext(), "Open Youtube", Toast.LENGTH_SHORT).show();
                        break;
                }
                return null;
            }
        });
    }
}
