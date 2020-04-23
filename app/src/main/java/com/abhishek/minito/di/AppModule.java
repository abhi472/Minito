package com.abhishek.minito.di;

import dagger.Module;

@Module(includes = {DatabaseModule.class,
        NetworkModule.class,
        RepositoryModule.class,
        ViewModelModule.class})
class AppModule {
}
