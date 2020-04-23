
package com.abhishek.minito.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ZomatoSearchBody implements Parcelable
{

    @SerializedName("results_found")
    @Expose
    private Integer resultsFound;
    @SerializedName("results_start")
    @Expose
    private Integer resultsStart;
    @SerializedName("results_shown")
    @Expose
    private Integer resultsShown;
    @SerializedName("restaurants")
    @Expose
    private List<Restaurant> restaurants = null;
    public final static Creator<ZomatoSearchBody> CREATOR = new Creator<ZomatoSearchBody>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ZomatoSearchBody createFromParcel(Parcel in) {
            return new ZomatoSearchBody(in);
        }

        public ZomatoSearchBody[] newArray(int size) {
            return (new ZomatoSearchBody[size]);
        }

    }
    ;

    protected ZomatoSearchBody(Parcel in) {
        this.resultsFound = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.resultsStart = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.resultsShown = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.restaurants, (Restaurant.class.getClassLoader()));
    }

    public ZomatoSearchBody() {
    }

    public Integer getResultsFound() {
        return resultsFound;
    }

    public void setResultsFound(Integer resultsFound) {
        this.resultsFound = resultsFound;
    }

    public Integer getResultsStart() {
        return resultsStart;
    }

    public void setResultsStart(Integer resultsStart) {
        this.resultsStart = resultsStart;
    }

    public Integer getResultsShown() {
        return resultsShown;
    }

    public void setResultsShown(Integer resultsShown) {
        this.resultsShown = resultsShown;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(resultsFound);
        dest.writeValue(resultsStart);
        dest.writeValue(resultsShown);
        dest.writeList(restaurants);
    }

    public int describeContents() {
        return  0;
    }

}
