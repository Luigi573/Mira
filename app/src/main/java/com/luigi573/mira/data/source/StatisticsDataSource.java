package com.luigi573.mira.data.source;

import com.luigi573.mira.data.Statistics;

import io.reactivex.Flowable;

public interface StatisticsDataSource {

    Flowable<Statistics> getStatistics();

    Flowable<Statistics> getStatistics(String area);
}
