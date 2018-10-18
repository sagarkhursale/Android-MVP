package com.sagar.androidmvp.http;

import com.sagar.androidmvp.http.apimodel.OmdbApi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MoreInfoApiService {


    @GET("/")
    Observable<OmdbApi> getCountry(@Query("t") String title);

}
