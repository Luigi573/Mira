package com.luigi573.mira.statistics;

import com.luigi573.mira.di.ActivityScoped;
import com.luigi573.mira.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StatisticsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract StatisticsFragment statisticsFragment();

    @Binds
    @ActivityScoped
    abstract StatisticsContract.Presenter statisticsPresenter(StatisticsPresenter presenter);
}
