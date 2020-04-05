package com.app.covidstats.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

//    @Binds
//    @IntoMap
//    @ViewModelKey(MainViewModel.class)
//    protected abstract ViewModel mainViewModel(MainViewModel mainViewModel);
}
