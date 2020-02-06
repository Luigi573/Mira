package com.luigi573.mira.data.source;

import com.luigi573.mira.data.Statistics;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public class StatisticsRepository implements StatisticsDataSource{
    private StatisticsDataSource mLocalDataSource;
    private StatisticsDataSource mRemoteDataSource;
    @Inject
    public StatisticsRepository(@Local StatisticsDataSource localDataSource,
                                @Remote StatisticsDataSource remoteDataSource) {
        this.mLocalDataSource = localDataSource;
        this.mRemoteDataSource = remoteDataSource;
    }


    @Override
    public Flowable<Statistics> getStatistics(String area) {
        return mRemoteDataSource.getStatistics(area);
    }

    @Override
    public Flowable<Statistics> getStatistics() {
        return mRemoteDataSource.getStatistics();
    }
}
