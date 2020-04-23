package com.abhishek.minito.di;


import com.abhishek.minito.repository.ApiRepository;
import com.abhishek.minito.repository.ApiRepositoryHelper;
import com.abhishek.minito.repository.DatabaseRepository;
import com.abhishek.minito.repository.DatabaseRepositoryHelper;

import dagger.Binds;
import dagger.Module;

@Module
public interface RepositoryModule {

    @Binds
    ApiRepository bindApiRepository(ApiRepositoryHelper helper);

    @Binds
    DatabaseRepository bindDatabaseRepository(DatabaseRepositoryHelper helper);
}
