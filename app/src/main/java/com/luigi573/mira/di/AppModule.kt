package com.luigi573.mira.di

import com.luigi573.mira.BuildConfig
import com.luigi573.mira.data.source.DefaultStatDataRepository
import com.luigi573.mira.data.source.StatDataRepository
import com.luigi573.mira.data.source.StatDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.annotation.AnnotationRetention.RUNTIME

@Module
object AppModule {
    @Qualifier
    @Retention(RUNTIME)
    annotation class StatRemoteDataSource

    @Qualifier
    @Retention(RUNTIME)
    annotation class StatLocalDataSource


    @JvmStatic
    @Singleton
    @Provides
    fun providesStatDataRepository(
            @StatRemoteDataSource remoteDataSource: StatDataSource
    ) : StatDataRepository {
        return DefaultStatDataRepository(remoteDataSource)
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.HTTP_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}