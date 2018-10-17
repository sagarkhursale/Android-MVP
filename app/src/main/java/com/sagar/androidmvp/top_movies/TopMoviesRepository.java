package com.sagar.androidmvp.top_movies;

import com.sagar.androidmvp.http.MoreInfoApiService;
import com.sagar.androidmvp.http.MovieApiService;
import com.sagar.androidmvp.http.apimodel.OmdbApi;
import com.sagar.androidmvp.http.apimodel.ProductionCountry;
import com.sagar.androidmvp.http.apimodel.Result;
import com.sagar.androidmvp.http.apimodel.TopRated;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


public class TopMoviesRepository implements Repository {
    private MovieApiService movieApiService;
    private MoreInfoApiService moreInfoApiService;
    private List<String> countries;
    private List<Result> results;
    private long timestamp;

    private static final long STALE_MS = 20 * 1000; // Data is stale after 20 seconds.


    public TopMoviesRepository(MovieApiService movieApiService, MoreInfoApiService moreInfoApiService) {
        this.movieApiService = movieApiService;
        this.moreInfoApiService = moreInfoApiService;
        this.timestamp = System.currentTimeMillis();
        countries = new ArrayList<>();
        results = new ArrayList<>();
    }


    private boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }


    @Override
    public Observable<Result> getResultsFromMemory() {
        if (isUpToDate()) {
            return Observable.fromIterable(results);
        } else {
            timestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }


    @Override
    public Observable<Result> getResultsFromNetwork() {
        Observable<TopRated> topRatedObservable = movieApiService.getTopRatedMovies(1).concatWith(movieApiService.getTopRatedMovies(2).concatWith(movieApiService.getTopRatedMovies(3)));
        return topRatedObservable.concatMap(new Function<TopRated, ObservableSource<? extends Result>>() {
            @Override
            public ObservableSource<? extends Result> apply(TopRated topRated) throws Exception {
                return Observable.fromIterable(topRated.getResults());
            }
        }).doOnNext(new Consumer<Result>() {
            @Override
            public void accept(Result result) throws Exception {
                results.add(result);
            }
        });
    }


    @Override
    public Observable<String> getCountriesFromMemory() {
        if (isUpToDate()) {
            return Observable.fromIterable(countries);
        } else {
            timestamp = System.currentTimeMillis();
            countries.clear();
            return Observable.empty();
        }
    }


    @Override
    public Observable<ProductionCountry> getCountriesFromNetwork() {
        return getResultsFromNetwork().concatMap(new Function<Result, ObservableSource<OmdbApi>>() {
            @Override
            public ObservableSource<OmdbApi> apply(Result result) throws Exception {
                return moreInfoApiService.getCountry(result.getTitle());
            }
        }).concatMap(new Function<OmdbApi, Observable<ProductionCountry>>() {
            @Override
            public Observable<ProductionCountry> apply(OmdbApi omdbApi) throws Exception {
                return Observable.fromIterable(omdbApi.getProductionCountries());
            }
        }).doOnNext(new Consumer<ProductionCountry>() {
            @Override
            public void accept(ProductionCountry productionCountry) throws Exception {
                countries.add(productionCountry.getName());
            }
        });
    }


    @Override
    public Observable<String> getCountryData() {
        return getCountriesFromMemory().switchIfEmpty(getCountriesFromMemory());
    }


    @Override
    public Observable<Result> getResultData() {
        return getResultsFromMemory().switchIfEmpty(getResultsFromNetwork());
    }

// END
}
