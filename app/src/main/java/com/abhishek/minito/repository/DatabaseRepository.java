package com.abhishek.minito.repository;


import com.abhishek.minito.model.RestaurantInner;

import java.util.List;

import io.reactivex.Single;

public interface DatabaseRepository {

    Long saveRestaurant(RestaurantInner restaurantInner);

    Single<List<RestaurantInner>> getRestaurants();


}
