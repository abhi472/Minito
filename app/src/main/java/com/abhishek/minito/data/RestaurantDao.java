package com.abhishek.minito.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.abhishek.minito.model.RestaurantInner;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long saveRestaurants(RestaurantInner albumEntity);

    @Query("SELECT * FROM restaurants")
    Single<List<RestaurantInner>> getRestaurants();
}
