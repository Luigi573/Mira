package com.luigi573.mira.data.source.remote;

import android.util.Log;

import com.luigi573.mira.data.Statistics;
import com.luigi573.mira.data.source.Remote;
import com.luigi573.mira.data.source.StatisticsDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

@Singleton
@Remote
public class StatisticsRemoteDataSource implements StatisticsDataSource {
    private Retrofit mRetrofit;

    @Inject
    public StatisticsRemoteDataSource(Retrofit retrofit) {
        mRetrofit = retrofit;

    }

    @Override
    public Flowable<Statistics> getStatistics() {
        Log.v("DDD", "getStatistics");
        return mRetrofit.create(StatisticsDataService.class).getAreaStat()
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Flowable<Statistics> getStatistics(String area) {
        return mRetrofit.create(StatisticsDataService.class).getAreaStat(area)
                .subscribeOn(Schedulers.io())
                .flatMap(Flowable::fromIterable);
    }


}
