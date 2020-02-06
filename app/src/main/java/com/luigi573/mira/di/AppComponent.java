package com.luigi573.mira.di;

import com.luigi573.mira.MiraApp;
import com.luigi573.mira.data.source.StatisticDataSourceModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class
        , AndroidSupportInjectionModule.class
        , ActivityBindingModule.class
        , AppModule.class
        , StatisticDataSourceModule.class})
public interface AppComponent extends AndroidInjector<MiraApp> {


    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(MiraApp application);

        AppComponent build();
    }

}
