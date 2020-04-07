package com.app.covidstats.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.app.covidstats.api.model.CountryStats;

import java.util.List;

@Dao
public interface StatsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMovies(List<CountryStats> countryStats);

    @Query("SELECT * FROM `CountryStats`")
    List<CountryStats> getStats();
}
