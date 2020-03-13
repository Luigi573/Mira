package com.luigi573.mira.data.source

import com.luigi573.mira.data.source.remote.FakeRemoteDataSource
import com.luigi573.mira.di.AppModule.StatRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object StatisticDataSourceModule {


    @JvmStatic
    @Singleton
    @StatRemoteDataSource
    @Provides
    fun providesStatRemoteDataSource() : StatDataSource {
        return FakeRemoteDataSource()
    }
}