package com.app.covidstats.ui;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.covidstats.adapter.StatsAdapter;
import com.app.covidstats.api.Repository;
import com.app.covidstats.api.Response;
import com.app.covidstats.base.BaseViewModel;
import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class MainViewModel extends BaseViewModel {
    private Repository repository;
    private StatsAdapter adapter;

    private MutableLiveData<String> toasMessage = new MutableLiveData<>();

    public ObservableBoolean isLoading = new ObservableBoolean();

    public MutableLiveData<String> getToasMessage() {
        return toasMessage;
    }

    public void setToasMessage(MutableLiveData<String> toasMessage) {
        this.toasMessage = toasMessage;
    }

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
        isLoading.set(true);
    }

    public void getStats() {
        Disposable disposable = repository.getStats().subscribeWith(new DisposableObserver<Response>() {
            @Override
            public void onNext(Response response) {
                Log.d("---", new Gson().toJson(response));
                adapter.setData(response.getCountries_stat());
                isLoading.set(false);
                //save to db
                if (response.getCountries_stat().size() > 0) {
                    repository.saveDataToDB(response.getCountries_stat());
                }
            }

            @Override
            public void onError(Throwable e) {
                toasMessage.setValue(e.getLocalizedMessage());
                isLoading.set(false);
                //load from db
                adapter.setData(repository.getDataFromDB());
            }

            @Override
            public void onComplete() {

            }
        });
        launchDisposable(disposable);
    }

    public void onRefresh() {
        isLoading.set(true);
        getStats();
    }
}
