package com.app.covidstats.adapter;

import androidx.lifecycle.ViewModel;

import com.app.covidstats.api.model.CountryStats;

public class StatsAdapterViewModel extends ViewModel{
    private CountryStats countryStats;

    public CountryStats getCountryStats() {
        return countryStats;
    }

    public void setCountryStats(CountryStats countryStats) {
        this.countryStats = countryStats;
    }

    //declare bind field, function....
}
