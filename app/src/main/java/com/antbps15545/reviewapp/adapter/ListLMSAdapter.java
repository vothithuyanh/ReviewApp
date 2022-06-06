package com.antbps15545.reviewapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.antbps15545.reviewapp.R;

import java.util.ArrayList;
import java.util.Collection;

public class ListLMSAdapter extends RecyclerView.Adapter<ListLMSAdapter.ViewHolder> implements Filterable {
    private OnItemTouchListener onItemTouchListener;
    Context context;

    public interface OnItemTouchListener {
        void onClick(View view, int position);
    }
    ArrayList<String> list;
    private ArrayList<String> listFiltered;
    public ListLMSAdapter(Context context, ArrayList<String> list, OnItemTouchListener listener) {
        this.context = context;
        this.list = list;
        this.onItemTouchListener = listener;
        listFiltered = new ArrayList<>(list);
    }
    @NonNull
    @Override
    public ListLMSAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lms, parent, false);
        ListLMSAdapter.ViewHolder viewHolder = new ListLMSAdapter.ViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ListLMSAdapter.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        String s = list.get(position);
        holder.tv.setText(s);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemTouchListener.onClick(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String input = charSequence.toString();
                ArrayList<String> filteredList = new ArrayList<>();
                if (input.isEmpty()) {
                    filteredList.addAll(listFiltered);
                } else {

                    for (String row : listFiltered) {
                        if (row.toLowerCase().contains(input.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                list.clear();
                list.addAll((Collection<? extends String>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }
}