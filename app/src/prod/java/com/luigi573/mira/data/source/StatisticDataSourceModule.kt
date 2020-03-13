package com.luigi573.mira.data.source

import com.luigi573.mira.data.source.remote.StatRemoteDataSource
import com.luigi573.mira.di.AppModule
import javax.inject.Singleton
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object StatisticDataSourceModule {
    @JvmStatic
    @Singleton
    @AppModule.StatRemoteDataSource
    @Provides
    fun providesStatRemoteDataSource(retrofit: Retrofit) : StatDataSource {
        return StatRemoteDataSource(retrofit)
    }
}