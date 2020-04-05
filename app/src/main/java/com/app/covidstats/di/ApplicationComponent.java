package com.app.covidstats.di;

import com.app.covidstats.App;
import com.app.covidstats.adapter.StatsAdapter;
import com.app.covidstats.ui.StatsFragment;
import com.app.covidstats.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        ApiModule.class,
//        DbModule.class,
        ApplicationModule.class,
        ViewModelModule.class})
@Singleton
public interface ApplicationComponent {

    void inject(App app);

    void inject(MainActivity activity);

    void inject(StatsFragment fragment);
}
