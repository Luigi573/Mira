package com.luigi573.mira.data.source.remote;

import com.luigi573.mira.data.Statistics;
import com.luigi573.mira.data.source.Remote;
import com.luigi573.mira.data.source.StatisticsDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
@Remote
public class FakeRemoteDataSource implements StatisticsDataSource {
    @Inject
    public FakeRemoteDataSource() {
    }


    @Override
    public Flowable<Statistics> getStatistics() {
        return Flowable.just(new Statistics(111
                ,111
                ,111
                ,111
                ,111
                , "https://img1.dxycdn.com/2020/0123/733/3392575782185696736-73.jpg"));
    }

    @Override
    public Flowable<Statistics> getStatistics(String area) {
        return null;
    }
}
