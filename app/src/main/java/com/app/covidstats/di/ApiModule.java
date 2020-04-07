package com.app.covidstats.di;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.app.covidstats.adapter.StatsAdapter;
import com.app.covidstats.api.ApiService;
import com.app.covidstats.api.Repository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    /*
     * The method returns the Gson object
     * */
    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }


    /*
     * The method returns the Cache object
     * */
    @Provides
    @Singleton
    Cache provideCache(Application application) {
        long cacheSize = 10 * 1024 * 1024; // 10 MB
        File httpCacheDirectory = new File(application.getCacheDir(), "http-cache");
        return new Cache(httpCacheDirectory, cacheSize);
    }


    /*
     * The method returns the Okhttp object
     * */
    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.cache(cache);
        httpClient.addInterceptor(new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder()
                        .addHeader("x-rapidapi-host", "coronavirus-monitor.p.rapidapi.com")
                        .addHeader("x-rapidapi-key", "txpQNp1H38msh7789euJggOk1WL8p1VxJnCjsnQXqVNfYWUTiO");
                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        });
        //httpClient.addNetworkInterceptor(new RequestInterceptor());
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        return httpClient.build();
    }

    @Provides
    @Singleton
    Interceptor getHeaderInterceptor() {
        return new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {
                Request.Builder request = chain.request().newBuilder()
                        .addHeader("x-rapidapi-host", "coronavirus-monitor.p.rapidapi.com")
                        .addHeader("x-rapidapi-key", "txpQNp1H38msh7789euJggOk1WL8p1VxJnCjsnQXqVNfYWUTiO");
                return chain.proceed(request.build());
            }
        };
    }


    /*
     * The method returns the Retrofit object
     * */
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://coronavirus-monitor.p.rapidapi.com/")
                .client(okHttpClient)
                .build();
    }

    /*
     * We need the MovieApiService module.
     * For this, We need the Retrofit object, Gson, Cache and OkHttpClient .
     * So we will define the providers for these objects here in this module.
     *
     * */

    @Provides
    @Singleton
    ApiService getApiClient(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

//    // simple
//    @Provides
//    @Singleton
//    ApiService getService() {
//        return new Retrofit
//                .Builder()
//                .baseUrl("https://coronavirus-monitor.p.rapidapi.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build().create(ApiService.class);
//    }

//    @Provides
//    @Singleton
//    CompositeDisposable getcoDisposable() {
//        return new CompositeDisposable();
//    }

//    @Provides
//    @Singleton
//    StatsAdapter getAdapter() {
//        return new StatsAdapter();
//    }
}
