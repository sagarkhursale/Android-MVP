package com.sagar.androidmvp.http;

import com.sagar.androidmvp.http.apimodel.OmdbApi;
import com.sagar.finalmvp.http.apimodel.place_detail_api.InfodbApi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MoreInfoApiService {


    @GET("/")
    Observable<OmdbApi> getCountry(@Query("movie_id") String movieId);

}
