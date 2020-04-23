package com.abhishek.minito.data

import com.abhishek.minito.model.RestaurantInner

sealed class BaseCommand {

    class Error(val errorString: Int?): BaseCommand()

    class Success(val list: List<Object>?): BaseCommand()

}