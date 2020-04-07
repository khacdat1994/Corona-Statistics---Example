package com.app.covidstats.base;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseViewModel extends ViewModel {

    CompositeDisposable disposable = new CompositeDisposable();

    public void launchDisposable(Disposable _dp) {
        disposable.add(_dp);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
