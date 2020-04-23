package com.abhishek.minito.remote;

import com.abhishek.minito.model.Cuisine;
import com.abhishek.minito.model.CuisineResponse;
import com.abhishek.minito.model.ZomatoSearchBody;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class ApiServiceHelper implements ApiService {

    private final ApiService service;

    @Inject
    public ApiServiceHelper(ApiService service) {
        this.service = service;
    }


    @Override
    public Observable<ZomatoSearchBody> getRestaurants(String key, String q, String sort, String lat, String lon) {
        return service.getRestaurants(key, q, sort, lat, lon);

    }

    @Override
    public Observable<CuisineResponse> getCuisines(String key, String q, String sort) {
        return service.getCuisines(key, q, sort);
    }
}
