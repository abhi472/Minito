package com.abhishek.minito.repository;


import com.abhishek.minito.model.Cuisine;
import com.abhishek.minito.model.CuisineResponse;
import com.abhishek.minito.model.ZomatoSearchBody;
import com.abhishek.minito.remote.ApiServiceHelper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class ApiRepositoryHelper implements ApiRepository {

    private ApiServiceHelper apiServiceHelper;

    @Inject
    public ApiRepositoryHelper (ApiServiceHelper apiServiceHelper) {
        this.apiServiceHelper = apiServiceHelper;
    }


    @Override
    public Observable<ZomatoSearchBody> getRestaurants(String key, String q, String sort, String lat, String lon) {
        return apiServiceHelper.getRestaurants(key, q, sort, lat, lon);
    }

    @Override
    public Observable<CuisineResponse> getCuisines(String apiKey, String q, String sort) {
        return apiServiceHelper.getCuisines(apiKey, q, sort);
    }

}
