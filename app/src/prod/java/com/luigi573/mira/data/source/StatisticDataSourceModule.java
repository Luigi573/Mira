package com.luigi573.mira.data.source;

import com.luigi573.mira.data.source.local.StatisticsLocalDataSource;
import com.luigi573.mira.data.source.remote.StatisticsRemoteDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class StatisticDataSourceModule {
    @Singleton
    @Binds
    @Local
    abstract StatisticsDataSource provideLocalDataSource(StatisticsLocalDataSource dataSource);

    @Singleton
    @Binds
    @Remote
    abstract StatisticsDataSource provideRemoteDataSource(StatisticsRemoteDataSource dataSource);
}
