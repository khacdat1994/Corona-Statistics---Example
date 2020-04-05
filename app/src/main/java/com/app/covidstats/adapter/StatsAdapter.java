package com.app.covidstats.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.covidstats.R;
import com.app.covidstats.api.CountryStats;
import com.app.covidstats.databinding.ViewItemStatsBinding;

import java.util.ArrayList;
import java.util.List;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.ViewHolder> {


    private ArrayList<CountryStats> mValues = new ArrayList<>();

    public StatsAdapter() {
    }

    public void setData(List<CountryStats> user) {
        mValues.clear();
        mValues.addAll(user);
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
        holder.viewItemUserBinding.getViewModel().setCountryStats(mValues.get(position));

        holder.viewItemUserBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewItemStatsBinding viewItemUserBinding;

        public ViewHolder(ViewItemStatsBinding _viewItemUserBinding) {
            super(_viewItemUserBinding.getRoot());
            this.viewItemUserBinding = _viewItemUserBinding;
            this.viewItemUserBinding.setViewModel(new StatsAdapterViewModel());
        }
    }
}
