package com.sagar.androidmvp.top_movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.sagar.androidmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopMoviesActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    private RecyclerView recyclerView;

    @BindView(R.id.listActivity_rootView)
    private ViewGroup rootView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_movies);

        ButterKnife.bind(this);


        // end
    }



    // END
}
