package com.app.covidstats.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.covidstats.App;
import com.app.covidstats.R;
import com.app.covidstats.adapter.StatsAdapter;
import com.app.covidstats.databinding.FragmentStatsBinding;
import com.app.covidstats.di.ViewModelFactory;

import javax.inject.Inject;

public class StatsFragment extends Fragment {

    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;
    private StatsAdapter adapter;

    @Inject
    ViewModelFactory viewModelFactory;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        FragmentStatsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_stats, container, false);

        recyclerView = binding.list;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);

        binding.setViewModel(mainViewModel);
        //
        adapter = new StatsAdapter();
        mainViewModel.setAdapter(adapter);
        mainViewModel.getStats();

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.component.inject(this);
    }
}
