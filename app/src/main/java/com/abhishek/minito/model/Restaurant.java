
package com.abhishek.minito.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant implements Parcelable
{

    @SerializedName("restaurant")
    @Expose
    private RestaurantInner restaurant;
    public final static Creator<Restaurant> CREATOR = new Creator<Restaurant>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        public Restaurant[] newArray(int size) {
            return (new Restaurant[size]);
        }

    }
    ;

    protected Restaurant(Parcel in) {
        this.restaurant = ((RestaurantInner) in.readValue((RestaurantInner.class.getClassLoader())));
    }

    public Restaurant() {
    }

    public RestaurantInner getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantInner restaurant) {
        this.restaurant = restaurant;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(restaurant);
    }

    public int describeContents() {
        return  0;
    }

}
