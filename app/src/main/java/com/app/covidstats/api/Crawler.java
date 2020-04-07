package com.app.covidstats.api;

import com.app.covidstats.api.model.CountryStats;
import com.app.covidstats.api.response.Response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.security.PublicKey;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class Crawler implements ApiService {

    @Inject
    public Crawler() {

    }

    @Override
    public Observable<Response> getStats() {
        return Observable.fromCallable(() -> {
            //
            Response response = new Response();
            ArrayList<CountryStats> list = new ArrayList<>();
            Document doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();
            Element element = doc.select("tbody").get(0);
            Elements elements = element.select("tr");
            //((city.getName() == null) ? "N/A" : city.getName())
            for (int i = 1; i < elements.size(); i++) {
                CountryStats countryStats = new CountryStats();
                countryStats.setCountry_name(elements.get(i).select("td").get(0).select("a.mt_a").text());
                countryStats.setCases(elements.get(i).select("td").get(1).text());
                countryStats.setNew_cases(elements.get(i).select("td").get(2).text());
                countryStats.setDeaths(elements.get(i).select("td").get(3).text());
                countryStats.setTotal_recovered(elements.get(i).select("td").get(5).text());
                //
                list.add(countryStats);
                response.setCountries_stat(list);
            }
            //Log.d("---", new Gson().toJson(response));
            //
            return response;
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
