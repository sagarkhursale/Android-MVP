package com.sagar.androidmvp.root;

import com.sagar.androidmvp.top_movies.TopMoviesActivity;

import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(TopMoviesActivity target);

}
