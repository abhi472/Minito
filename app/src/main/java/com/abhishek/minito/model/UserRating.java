
package com.abhishek.minito.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRating implements Parcelable
{

    @SerializedName("aggregate_rating")
    @Expose
    private String aggregateRating;

    public final static Creator<UserRating> CREATOR = new Creator<UserRating>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserRating createFromParcel(Parcel in) {
            return new UserRating(in);
        }

        public UserRating[] newArray(int size) {
            return (new UserRating[size]);
        }

    }
    ;

    protected UserRating(Parcel in) {
        this.aggregateRating = ((String) in.readValue((String.class.getClassLoader())));

    }

    public UserRating() {
    }

    public UserRating(String aggregateRating) {
        this.aggregateRating = aggregateRating;
    }

    public String getAggregateRating() {
        return aggregateRating;
    }

    public void setAggregateRating(String aggregateRating) {
        this.aggregateRating = aggregateRating;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(aggregateRating);
    }

    public int describeContents() {
        return  0;
    }

}
