package com.app.covidstats.di;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.app.covidstats.db.AppDatabase;
import com.app.covidstats.db.StatsDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    /*
     * The method returns the Database object
     * */
    @Provides
    @Singleton
    AppDatabase provideDatabase(@NonNull Application application) {
        return Room.databaseBuilder(application,
                AppDatabase.class, "Covid.db")
                .allowMainThreadQueries().build();
    }


    /*
     * We need the MovieDao module.
     * For this, We need the AppDatabase object
     * So we will define the providers for this here in this module.
     * */

    @Provides
    @Singleton
    StatsDao statsDao(@NonNull AppDatabase appDatabase) {
        return appDatabase.statsDao();
    }
}
