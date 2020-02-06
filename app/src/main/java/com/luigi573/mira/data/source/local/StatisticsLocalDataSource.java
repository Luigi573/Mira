package com.luigi573.mira.data.source.local;

import com.luigi573.mira.data.Statistics;
import com.luigi573.mira.data.source.Local;
import com.luigi573.mira.data.source.StatisticsDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
@Local
public class StatisticsLocalDataSource implements StatisticsDataSource {
    @Inject
    public StatisticsLocalDataSource() {
    }

    @Override
    public Flowable<Statistics> getStatistics() {
//        Log.v("DDD", "gets");
        return null;
    }

    @Override
    public Flowable<Statistics> getStatistics(String area) {
        return null;
    }

}
