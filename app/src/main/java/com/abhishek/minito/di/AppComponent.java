package com.abhishek.minito.di;


import com.abhishek.minito.MinitoApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        AppModule.class})
public interface AppComponent extends AndroidInjector<MinitoApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MinitoApp app);

        Builder database(DatabaseModule module);

        Builder network(NetworkModule module);



        AppComponent build();
    }

    @Override
    void inject(MinitoApp instance);
}
