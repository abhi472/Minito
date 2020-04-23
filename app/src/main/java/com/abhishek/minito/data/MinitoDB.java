package com.abhishek.minito.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.abhishek.minito.BuildConfig;
import com.abhishek.minito.model.RestaurantInner;
import com.abhishek.minito.model.TypeConvertor;

@Database(entities = {RestaurantInner.class},
        version = BuildConfig.DB_SCHEMA_VERSION,
        exportSchema = false)
@TypeConverters({TypeConvertor.class})
public abstract class MinitoDB extends RoomDatabase {

    public abstract RestaurantDao restaurantDao();

}
