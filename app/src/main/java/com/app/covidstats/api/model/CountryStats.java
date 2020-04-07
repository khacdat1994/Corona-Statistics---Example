package com.app.covidstats.api.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CountryStats {

    @PrimaryKey
    @ColumnInfo(name = "country_name")
    @NonNull
    private String country_name;
    @ColumnInfo(name = "cases")
    private String cases;
    @ColumnInfo(name = "deaths")
    private String deaths;
    @ColumnInfo(name = "region")
    private String region;
    @ColumnInfo(name = "total_recovered")
    private String total_recovered;
    @ColumnInfo(name = "new_deaths")
    private String new_deaths;
    @ColumnInfo(name = "new_cases")
    private String new_cases;
    @ColumnInfo(name = "serious_critical")
    private String serious_critical;
    @ColumnInfo(name = "active_cases")
    private String active_cases;
    @ColumnInfo(name = "total_cases_per_1m_population")
    private String total_cases_per_1m_population;

    public CountryStats() {
    }

    public CountryStats(String country_name, String cases, String deaths, String region, String total_recovered, String new_deaths, String new_cases, String serious_critical, String active_cases, String total_cases_per_1m_population) {
        this.country_name = country_name;
        this.cases = cases;
        this.deaths = deaths;
        this.region = region;
        this.total_recovered = total_recovered;
        this.new_deaths = new_deaths;
        this.new_cases = new_cases;
        this.serious_critical = serious_critical;
        this.active_cases = active_cases;
        this.total_cases_per_1m_population = total_cases_per_1m_population;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTotal_recovered() {
        return total_recovered;
    }

    public void setTotal_recovered(String total_recovered) {
        this.total_recovered = total_recovered;
    }

    public String getNew_deaths() {
        return new_deaths;
    }

    public void setNew_deaths(String new_deaths) {
        this.new_deaths = new_deaths;
    }

    public String getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(String new_cases) {
        this.new_cases = new_cases;
    }

    public String getSerious_critical() {
        return serious_critical;
    }

    public void setSerious_critical(String serious_critical) {
        this.serious_critical = serious_critical;
    }

    public String getActive_cases() {
        return active_cases;
    }

    public void setActive_cases(String active_cases) {
        this.active_cases = active_cases;
    }

    public String getTotal_cases_per_1m_population() {
        return total_cases_per_1m_population;
    }

    public void setTotal_cases_per_1m_population(String total_cases_per_1m_population) {
        this.total_cases_per_1m_population = total_cases_per_1m_population;
    }
}
