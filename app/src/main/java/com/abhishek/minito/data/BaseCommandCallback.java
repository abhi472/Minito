package com.abhishek.minito.data;

import com.abhishek.minito.model.RestaurantInner;

import java.util.List;

public interface BaseCommandCallback {

    void success(List<RestaurantInner> list);

}
