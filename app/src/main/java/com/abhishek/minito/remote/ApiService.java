package com.abhishek.minito.remote;


import com.abhishek.minito.model.Cuisine;
import com.abhishek.minito.model.CuisineResponse;
import com.abhishek.minito.model.ZomatoSearchBody;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiService {

    @GET("search")
    Observable<ZomatoSearchBody> getRestaurants(@Header("user-key") String key,
                                                @Query("q") String q,
                                                @Query("sort") String sort,
                                                @Query("lat") String lat,
                                                @Query("lon") String lon);

    @GET("cuisines")
    Observable<CuisineResponse> getCuisines(@Header("user-key") String key,
                                            @Query("lat") String q,
                                            @Query("lon") String sort);
}
