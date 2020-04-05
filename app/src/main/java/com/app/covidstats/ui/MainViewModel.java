package com.app.covidstats.ui;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.app.covidstats.adapter.StatsAdapter;
import com.app.covidstats.api.Repository;
import com.app.covidstats.api.Response;
import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class MainViewModel extends ViewModel {
    private Repository repository;
    private StatsAdapter adapter;

    @Inject
    CompositeDisposable disposable;

    public StatsAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(StatsAdapter adapter) {
        this.adapter = adapter;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Inject
    public MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public void getStats() {
        disposable.add(repository.getStats().subscribeWith(new DisposableObserver<Response>() {
            @Override
            public void onNext(Response response) {
                Log.d("---",new Gson().toJson(response));
                adapter.setData(response.getCountries_stat());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }
}
