package com.luigi573.mira;

import com.luigi573.mira.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MiraApp extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
