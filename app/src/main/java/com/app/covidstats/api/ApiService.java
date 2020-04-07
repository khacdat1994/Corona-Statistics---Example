package com.app.covidstats.api;

import com.app.covidstats.api.response.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("coronavirus/cases_by_country.php")
    Observable<Response> getStats();
}
