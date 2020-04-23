package com.abhishek.minito.di;


import androidx.room.Room;


import com.abhishek.minito.MinitoApp;
import com.abhishek.minito.data.MinitoDB;
import com.abhishek.minito.data.RestaurantDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public MinitoDB provideTrackerDatabase(MinitoApp app) {
        return Room.databaseBuilder(app, MinitoDB.class, "minito.db")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    RestaurantDao provideAlbumDao(MinitoDB db) {
        return db.restaurantDao();
    }


}
