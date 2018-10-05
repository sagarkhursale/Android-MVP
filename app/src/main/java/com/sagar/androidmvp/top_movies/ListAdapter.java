package com.sagar.androidmvp.top_movies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sagar.androidmvp.R;
import java.util.List;



public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {

    private List<ViewModel> list;


    ListAdapter(List<ViewModel> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        return new ListItemViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        if (holder.movieName != null) {
            holder.movieName.setText(list.get(position).getName());
            holder.country.setText(list.get(position).getCountry());
        }
    }



    @Override
    public int getItemCount() {
        return list.size();
    }



    static class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView movieName;
        TextView country;

        ListItemViewHolder(View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.textView_list_movie_name);
            country = itemView.findViewById(R.id.textView_list_country);
        }
    }


    // END
}
