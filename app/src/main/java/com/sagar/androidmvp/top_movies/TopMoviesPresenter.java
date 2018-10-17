package com.sagar.androidmvp.top_movies;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



public class TopMoviesPresenter implements TopMoviesActivityMvp.Presenter {

    private TopMoviesActivityMvp.View view;
    private TopMoviesActivityMvp.Model model;


    TopMoviesPresenter(TopMoviesActivityMvp.Model model) {
        this.model = model;
    }



    @Override
    public void setView(TopMoviesActivityMvp.View view) {
        this.view = view;
    }



    @Override
    public void loadData() {

        model.result().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ViewModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (d.isDisposed())
                            d.dispose();
                    }


                    @Override
                    public void onNext(ViewModel viewModel) {
                        if (view != null) {
                            view.updateData(viewModel);
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (view != null) {
                            view.showSnackbar("Error Getting Movies..!");
                        }
                    }


                    @Override
                    public void onComplete() {

                    }
                });
    }



    @Override
    public void rxUnsubscribe() {

    }


    // END
}
