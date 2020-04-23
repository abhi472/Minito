package com.abhishek.minito.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cuisine_ implements Parcelable
{

    @SerializedName("cuisine_id")
    @Expose
    private Integer cuisineId;
    @SerializedName("cuisine_name")
    @Expose
    private String cuisineName;
    public final static Parcelable.Creator<Cuisine_> CREATOR = new Creator<Cuisine_>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Cuisine_ createFromParcel(Parcel in) {
            return new Cuisine_(in);
        }

        public Cuisine_[] newArray(int size) {
            return (new Cuisine_[size]);
        }

    }
            ;

    protected Cuisine_(Parcel in) {
        this.cuisineId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cuisineName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Cuisine_() {
    }

    public Integer getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Integer cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cuisineId);
        dest.writeValue(cuisineName);
    }

    public int describeContents() {
        return 0;
    }

}
