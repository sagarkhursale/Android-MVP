package com.sagar.androidmvp.root;

import android.app.Application;
import com.sagar.androidmvp.http.ApiModuleForInfo;
import com.sagar.androidmvp.http.ApiModuleForName;
import com.sagar.androidmvp.top_movies.TopMoviesModule;


public class App extends Application {

    private ApplicationComponent component;


    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModuleForName(new ApiModuleForName())
                .topMoviesModule(new TopMoviesModule())
                .apiModuleForInfo(new ApiModuleForInfo())
                .build();
    }


    public ApplicationComponent getComponent() {
        return component;
    }


    // END
}
