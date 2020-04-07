package com.app.covidstats.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.app.covidstats.api.model.CountryStats;

@Database(entities = {CountryStats.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract StatsDao statsDao();
}
