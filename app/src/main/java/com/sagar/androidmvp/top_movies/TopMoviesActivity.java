package com.sagar.androidmvp.top_movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.sagar.androidmvp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopMoviesActivity extends AppCompatActivity implements TopMoviesActivityMvp.View {

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    @BindView(R.id.listActivity_rootView)
    public ViewGroup rootView;

    private ListAdapter listAdapter;
    private List<ViewModel> resultList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_movies);

        ButterKnife.bind(this);

        listAdapter = new ListAdapter(resultList);
        recyclerView.setAdapter(listAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // end
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void updateData(ViewModel viewModel) {

    }


    @Override
    public void showSnackbar(String message) {

    }


    // END
}
