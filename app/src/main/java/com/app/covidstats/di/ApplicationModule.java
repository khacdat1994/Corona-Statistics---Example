package com.app.covidstats.di;

import android.app.Application;
import android.content.Context;

import com.app.covidstats.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private App app;

    public ApplicationModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApp() {
        return app;
    }

    @Provides
    @Singleton
    Context getContext() {
        return app;
    }
}
