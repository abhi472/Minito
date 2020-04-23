package com.abhishek.minito.repository;

import com.abhishek.minito.model.Cuisine;
import com.abhishek.minito.model.CuisineResponse;
import com.abhishek.minito.model.ZomatoSearchBody;
import java.util.List;

import io.reactivex.Observable;

public interface ApiRepository {

    Observable<ZomatoSearchBody>getRestaurants(String apiKey,
                                               String q,
                                               String sort,
                                               String lat,
                                               String lon);

    Observable<CuisineResponse>getCuisines(String apiKey, String q, String sort);


}
