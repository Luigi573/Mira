package com.luigi573.mira.data.source.remote

import com.luigi573.mira.data.Result
import com.luigi573.mira.data.Stat
import retrofit2.http.GET

interface StatApiService {
    @GET("/data/getStatisticsService")
    suspend fun getStat() : Stat
}