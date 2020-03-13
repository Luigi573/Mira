package com.luigi573.mira.statistics

import androidx.lifecycle.ViewModel
import com.luigi573.mira.di.ViewModelBuilder
import com.luigi573.mira.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class StatisticsModule {
    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    abstract fun statisticsFragment(): StatisticsFragment

    @Binds
    @IntoMap
    @ViewModelKey(StatisticsViewModel::class)
    abstract fun bindViewModel(viewModel: StatisticsViewModel): ViewModel
}