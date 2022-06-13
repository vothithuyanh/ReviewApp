package com.antbps15545.reviewapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends   RecyclerView.ViewHolder {

    ImageView flagView;
    TextView countryNameView;
    TextView populationView;

    // @itemView: recyclerview_item_layout.xml
    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);

        this.flagView = (ImageView) itemView.findViewById(R.id.imageView_flag);
        this.countryNameView = (TextView) itemView.findViewById(R.id.textView_countryName);
        this.populationView = (TextView) itemView.findViewById(R.id.textView_population);
    }
}
