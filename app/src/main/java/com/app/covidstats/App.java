package com.app.covidstats;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.app.covidstats.di.ApiModule;
import com.app.covidstats.di.ApplicationComponent;
import com.app.covidstats.di.ApplicationModule;
import com.app.covidstats.di.DaggerApplicationComponent;
import com.app.covidstats.di.DbModule;

public class App extends MultiDexApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static App instance;
    public static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component =
                DaggerApplicationComponent
                        .builder()
                        .apiModule(new ApiModule())
                        .applicationModule(new ApplicationModule(this))
                        .dbModule(new DbModule())
                        .build();

        component.inject(this);
    }
}
