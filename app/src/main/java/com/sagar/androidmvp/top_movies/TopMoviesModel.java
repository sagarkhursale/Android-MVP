package com.sagar.androidmvp.top_movies;

import io.reactivex.Observable;



public class TopMoviesModel implements TopMoviesActivityMvp.Model{

    private Repository mRepository;

    public TopMoviesModel(Repository repository) {
    this.mRepository=repository;
    }

    @Override
    public Observable<ViewModel> result() {
        return null;
    }

//
}
