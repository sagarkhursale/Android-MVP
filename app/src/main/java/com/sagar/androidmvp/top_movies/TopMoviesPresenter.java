package com.sagar.androidmvp.top_movies;


public class TopMoviesPresenter implements TopMoviesActivityMvp.Presenter {

    TopMoviesActivityMvp.View view;
    TopMoviesActivityMvp.Model model;


    public TopMoviesPresenter(TopMoviesActivityMvp.Model model) {
        this.model = model;
    }


    @Override
    public void setView(TopMoviesActivityMvp.View view) {
        this.view = view;
    }


    @Override
    public void loadData() {

    }


    @Override
    public void rxUnsubscribe() {

    }


    // END
}
