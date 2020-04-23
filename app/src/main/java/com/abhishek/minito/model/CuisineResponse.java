package com.abhishek.minito.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class CuisineResponse implements Parcelable {

    @SerializedName("cuisines")
    @Expose
    private List<Cuisine> cuisines = null;
    public CuisineResponse() {
    }

    protected CuisineResponse(Parcel in) {
        cuisines = in.createTypedArrayList(Cuisine.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(cuisines);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CuisineResponse> CREATOR = new Creator<CuisineResponse>() {
        @Override
        public CuisineResponse createFromParcel(Parcel in) {
            return new CuisineResponse(in);
        }

        @Override
        public CuisineResponse[] newArray(int size) {
            return new CuisineResponse[size];
        }
    };

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }


}
