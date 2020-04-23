package com.abhishek.minito.repository;



import com.abhishek.minito.data.MinitoDB;
import com.abhishek.minito.data.RestaurantDao;
import com.abhishek.minito.model.RestaurantInner;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class DatabaseRepositoryHelper implements DatabaseRepository {

    private MinitoDB db;
    private RestaurantDao restaurantDao;


    @Inject
    public DatabaseRepositoryHelper(MinitoDB db, RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        this.db = db;
    }


    @Override
    public Long saveRestaurant(RestaurantInner restaurantInner) {
        return restaurantDao.saveRestaurants(restaurantInner);

    }

    @Override
    public Single<List<RestaurantInner>> getRestaurants() {
        return restaurantDao.getRestaurants();
    }

}
