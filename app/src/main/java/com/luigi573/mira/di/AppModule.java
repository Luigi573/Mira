package com.luigi573.mira.di;

import com.luigi573.mira.BuildConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class AppModule {
    @Provides
    @Singleton
    public static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.HTTP_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
