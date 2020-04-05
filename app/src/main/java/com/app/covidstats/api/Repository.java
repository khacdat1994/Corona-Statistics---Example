package com.app.covidstats.api;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;

@Singleton
public class Repository {
    private static final String TAG = "Repository";
    private ApiService apiService;

    @Inject
    public Repository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<Response> getStats() {
        return apiService.getStats()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

//    public MutableLiveData<Response> getStats() {
//        final MutableLiveData<Response> mutableLiveData = new MutableLiveData<>();
//
//        apiService.getStats().enqueue(new Callback<Response>() {
//            @Override
//            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//                mutableLiveData.setValue(response.body());
//                Log.d(TAG,new Gson().toJson(response.body()));
//            }
//
//            @Override
//            public void onFailure(Call<Response> call, Throwable t) {
//
//            }
//        });
//
//        return mutableLiveData;
//    }
}
