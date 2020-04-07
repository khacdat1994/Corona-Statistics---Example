package com.app.covidstats.di;

import com.app.covidstats.App;
import com.app.covidstats.base.BaseActivity;
import com.app.covidstats.base.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        //ApiModule.class,
        CrawlerModule.class,
        DbModule.class,
        ApplicationModule.class,
        ViewModelModule.class})
@Singleton
public interface ApplicationComponent {

    void inject(App app);

    void inject(BaseActivity activity);

    void inject(BaseFragment fragment);
}
