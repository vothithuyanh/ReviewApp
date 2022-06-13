package com.antbps15545.reviewapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.antbps15545.reviewapp.fragment_example.CardViewExampleFragment;
import com.antbps15545.reviewapp.models.Country;

import java.util.List;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CountryViewHolder> {


    private List<Country> countries;
    private Context context;
    private LayoutInflater mLayoutInflater;

    public CustomRecyclerViewAdapter(Context context, List<Country> datas ) {
        this.context = context;
        this.countries = datas;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public CountryViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        // Inflate view from recyclerview_item_layout.xml
        View recyclerViewItem = mLayoutInflater.inflate(R.layout.recyclerview_item_layout, parent, false);

        recyclerViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRecyclerItemClick( (RecyclerView)parent, v);
            }
        });
        return new CountryViewHolder(recyclerViewItem);
    }


    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        // Cet country in countries via position
        Country country = this.countries.get(position);

        int imageResId = this.getDrawableResIdByName(country.getFlagName());
        // Bind data to viewholder
        holder.flagView.setImageResource(imageResId);
        holder.countryNameView.setText(country.getCountryName() );
        holder.populationView.setText("Population: "+ country.getPopulation());
    }

    @Override
    public int getItemCount() {
        return this.countries.size();
    }

    // Find Image ID corresponding to the name of the image (in the directory drawable).
    public int getDrawableResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "drawable", pkgName);
        Log.i(CardViewExampleFragment.LOG_TAG, "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    // Click on RecyclerView Item.
    private void handleRecyclerItemClick(RecyclerView recyclerView, View itemView) {
        int itemPosition = recyclerView.getChildLayoutPosition(itemView);
        Country country  = this.countries.get(itemPosition);

        Toast.makeText(this.context, country.getCountryName(), Toast.LENGTH_LONG).show();
    }
}
