package com.sagar.androidmvp.top_movies;


import com.sagar.androidmvp.http.apimodel.ProductionCountry;
import com.sagar.androidmvp.http.apimodel.Result;
import io.reactivex.Observable;


public interface Repository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<String> getCountriesFromMemory();

    Observable<ProductionCountry> getCountriesFromNetwork();

    Observable<String> getCountryData();

    Observable<Result> getResultData();

}
