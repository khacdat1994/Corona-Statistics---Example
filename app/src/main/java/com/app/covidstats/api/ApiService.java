package com.app.covidstats.api;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiService {
    @GET("coronavirus/cases_by_country.php")
    Observable<Response> getStats();
}
