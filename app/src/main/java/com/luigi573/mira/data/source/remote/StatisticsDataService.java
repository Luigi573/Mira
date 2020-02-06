package com.luigi573.mira.data.source.remote;

import com.luigi573.mira.data.Statistics;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StatisticsDataService {
    //全国
    @GET("/data/getStatisticsService")
    Flowable<Statistics> getAreaStat();

    //地区
    @GET("/data/getAreaStat/{area}")
    Flowable<List<Statistics>> getAreaStat(@Path("area") String area);

}
