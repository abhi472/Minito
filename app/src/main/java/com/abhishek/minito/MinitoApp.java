package com.abhishek.minito;

import android.content.Context;

import com.abhishek.minito.di.DaggerAppComponent;
import com.abhishek.minito.di.DatabaseModule;
import com.abhishek.minito.di.NetworkModule;
import com.facebook.stetho.Stetho;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MinitoApp extends DaggerApplication {
    AndroidInjector<? extends DaggerApplication> androidInjector;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        androidInjector = DaggerAppComponent.builder()
                .application(this)
                .network(new NetworkModule())
                .database(new DatabaseModule())
                .build();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return androidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this);

    }
}
