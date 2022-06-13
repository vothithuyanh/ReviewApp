package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.antbps15545.reviewapp.R;


public class RatingBarExampleFragment extends Fragment {

    private RatingBar ratingBarYours;
    private RatingBar ratingBarAll;

    private Button buttonSubmit;

    private TextView textViewYourCurrentRating;
    private TextView textViewRatingCount;
    private TextView textViewSumAllRating;
    private TextView textViewAverageAllRating;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating_bar_example, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}