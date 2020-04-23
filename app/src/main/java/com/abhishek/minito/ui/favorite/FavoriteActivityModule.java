package com.abhishek.minito.ui.favorite;

import com.abhishek.minito.repository.DatabaseRepository;
import com.abhishek.minito.ui.RestaurantListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class FavoriteActivityModule {

    @Provides
    RestaurantListAdapter adapterProvider(DatabaseRepository databaseRepository) {
        return new RestaurantListAdapter(databaseRepository, false);
    }
}
