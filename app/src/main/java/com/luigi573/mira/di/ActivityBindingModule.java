package com.luigi573.mira.di;

import com.luigi573.mira.statistics.StatisticsActivity;
import com.luigi573.mira.statistics.StatisticsModule;

import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = {StatisticsModule.class})
    public abstract StatisticsActivity statisticsActivity();

}
