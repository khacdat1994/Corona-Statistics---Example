package com.app.covidstats.di;

import com.app.covidstats.api.ApiService;
import com.app.covidstats.api.Crawler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CrawlerModule {

    @Provides
    @Singleton
    ApiService providerApiService() {
        return new Crawler();
    }
}
