package com.sagar.androidmvp.top_movies;

import io.reactivex.Observable;


public interface TopMoviesActivityMvp {


    interface View {
        void updateData(ViewModel viewModel);

        void showSnackbar(String message);
    }


    interface Presenter {

        void setView(TopMoviesActivityMvp.View view);

        void loadData();

        void rxUnsubscribe();

    }


    interface Model {

        Observable<ViewModel> result();
    }


    //
}
