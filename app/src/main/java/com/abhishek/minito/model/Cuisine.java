package com.abhishek.minito.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cuisine implements Parcelable
{

    @SerializedName("cuisine")
    @Expose
    private Cuisine_ cuisine;
    public final static Parcelable.Creator<Cuisine> CREATOR = new Creator<Cuisine>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Cuisine createFromParcel(Parcel in) {
            return new Cuisine(in);
        }

        public Cuisine[] newArray(int size) {
            return (new Cuisine[size]);
        }

    }
            ;

    protected Cuisine(Parcel in) {
        this.cuisine = ((Cuisine_) in.readValue((Cuisine_.class.getClassLoader())));
    }

    public Cuisine() {
    }

    public Cuisine_ getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine_ cuisine) {
        this.cuisine = cuisine;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cuisine);
    }

    public int describeContents() {
        return 0;
    }

}