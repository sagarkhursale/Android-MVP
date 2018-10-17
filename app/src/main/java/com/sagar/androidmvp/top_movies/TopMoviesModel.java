package com.sagar.androidmvp.top_movies;

import com.sagar.androidmvp.http.apimodel.Result;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;



public class TopMoviesModel implements TopMoviesActivityMvp.Model{

    private Repository mRepository;


    TopMoviesModel(Repository repository) {
    this.mRepository=repository;
    }


    @Override
    public Observable<ViewModel> result() {
        return Observable.zip(mRepository.getResultData(), mRepository.getCountryData(), new BiFunction<Result, String, ViewModel>() {
            @Override
            public ViewModel apply(Result result, String selection) throws Exception {
                return new ViewModel(result.getTitle(),selection);
            }
        });
    }

//
}
