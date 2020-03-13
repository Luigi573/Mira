package com.luigi573.mira.di

import android.content.Context
import com.luigi573.mira.MiraApp
import com.luigi573.mira.data.source.StatisticDataSourceModule
import com.luigi573.mira.statistics.StatisticsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        StatisticsModule::class,
        StatisticDataSourceModule::class
    ])
interface AppComponent : AndroidInjector<MiraApp> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}