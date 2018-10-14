package com.sagar.androidmvp.root;

import com.sagar.androidmvp.http.ApiModuleForInfo;
import com.sagar.androidmvp.http.ApiModuleForName;
import com.sagar.androidmvp.top_movies.TopMoviesActivity;
import com.sagar.androidmvp.top_movies.TopMoviesModule;

import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(modules = {ApplicationModule.class, ApiModuleForName.class,ApiModuleForInfo.class,TopMoviesModule.class})
public interface ApplicationComponent {

    void inject(TopMoviesActivity target);

}
