package com.app.covidstats.adapter;

import androidx.lifecycle.ViewModel;

import com.app.covidstats.api.CountryStats;

public class StatsAdapterViewModel extends ViewModel {
    private CountryStats countryStats;

    public CountryStats getCountryStats() {
        return countryStats;
    }

    public void setCountryStats(CountryStats countryStats) {
        this.countryStats = countryStats;
    }
}
