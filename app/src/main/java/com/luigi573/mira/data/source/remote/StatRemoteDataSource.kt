package com.luigi573.mira.data.source.remote

import com.luigi573.mira.data.Stat
import com.luigi573.mira.data.Result
import com.luigi573.mira.data.source.StatDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class StatRemoteDataSource constructor(val retrofit: Retrofit): StatDataSource {
    override suspend fun getStat(): Result<Stat> = withContext(Dispatchers.IO) {
        return@withContext try {
            retrofit.create(StatApiService::class.java).getStat().let {
                Result.Success(it)
            }
        } catch (e : Exception) {
            Result.Error(e)
        }
    }

}