package com.abhishek.minito.ui.search;

import com.abhishek.minito.repository.DatabaseRepository;
import com.abhishek.minito.repository.DatabaseRepositoryHelper;
import com.abhishek.minito.ui.BaseViewModel;
import com.abhishek.minito.ui.RestaurantListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchActivityModule {

    @Provides
    RestaurantListAdapter adapterProvider(DatabaseRepository databaseRepository) {
        return new RestaurantListAdapter(databaseRepository, true);
    }

}
