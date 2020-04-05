package com.app.covidstats.api;

import java.util.ArrayList;

public class Response {
    private ArrayList<CountryStats> countries_stat;

    public Response(ArrayList<CountryStats> countries_stat) {
        this.countries_stat = countries_stat;
    }

    public Response() {
    }

    public ArrayList<CountryStats> getCountries_stat() {
        return countries_stat;
    }

    public void setCountries_stat(ArrayList<CountryStats> countries_stat) {
        this.countries_stat = countries_stat;
    }
}
