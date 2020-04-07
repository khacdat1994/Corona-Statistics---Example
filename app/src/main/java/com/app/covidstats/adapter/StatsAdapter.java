package com.app.covidstats.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.covidstats.R;
import com.app.covidstats.api.model.CountryStats;
import com.app.covidstats.databinding.ViewItemStatsBinding;

import java.util.ArrayList;
import java.util.List;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.ViewHolder> {

    private ArrayList<CountryStats> mValues = new ArrayList<>();

    public StatsAdapter() {
    }

    public void setData(List<CountryStats> countryStats) {
        mValues.clear();
        mValues.addAll(countryStats);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //
        ViewItemStatsBinding viewItemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.view_item_stats, parent, false);
        return new ViewHolder(viewItemUserBinding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        StatsAdapterViewModel viewModel = new StatsAdapterViewModel();
        viewModel.setCountryStats(mValues.get(position));

        holder.viewItemStatsBinding.setViewModel(viewModel);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewItemStatsBinding viewItemStatsBinding;

        public ViewHolder(ViewItemStatsBinding viewItemStatsBinding) {
            super(viewItemStatsBinding.getRoot());
            this.viewItemStatsBinding = viewItemStatsBinding;
        }
    }
}
