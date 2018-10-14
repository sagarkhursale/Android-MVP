package com.sagar.androidmvp.top_movies;

import com.sagar.androidmvp.http.ApiModuleForName;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;


@Module(includes = ApiModuleForName.class)
public class TopMoviesModule{


    @Provides
    public TopMoviesActivityMvp.Presenter provideTopMoviesActivityPresenter(TopMoviesActivityMvp.Model topMoviesModel){
        return new TopMoviesPresenter(topMoviesModel);
    }


    @Provides
    public TopMoviesActivityMvp.Model provideTopMoviesActivityModel(Repository repository){
        return new TopMoviesModel(repository);
    }




    

}
