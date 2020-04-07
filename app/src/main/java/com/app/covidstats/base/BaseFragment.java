package com.app.covidstats.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.covidstats.App;
import com.app.covidstats.di.ViewModelFactory;

import javax.inject.Inject;

public abstract class BaseFragment extends Fragment {

    @Inject
    protected ViewModelFactory viewModelFactory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.component.inject(this);
    }
}
