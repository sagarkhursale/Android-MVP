package com.sagar.androidmvp.top_movies;

import com.sagar.androidmvp.http.MoreInfoApiService;
import com.sagar.androidmvp.http.MovieApiService;
import com.sagar.androidmvp.http.apimodel.Result;

import io.reactivex.Observable;


public class TopMoviesRepository implements Repository {
    private MovieApiService movieApiService;
    private MoreInfoApiService moreInfoApiService;


    public TopMoviesRepository(MovieApiService movieApiService, MoreInfoApiService moreInfoApiService) {
        this.movieApiService = movieApiService;
        this.moreInfoApiService = moreInfoApiService;
    }


    @Override
    public Observable<Result> getResultsFromMemory() {
        return null;
    }


    @Override
    public Observable<Result> getResultsFromNetwork() {
        return null;
    }


    @Override
    public Observable<String> getCountriesFromMemory() {
        return null;
    }


    @Override
    public Observable<String> getCountriesFromNetwork() {
        return null;
    }


    @Override
    public Observable<String> getCountryData() {
        return null;
    }


    @Override
    public Observable<Result> getResultData() {
        return null;
    }

// END
}
