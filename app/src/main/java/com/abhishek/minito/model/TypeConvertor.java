package com.abhishek.minito.model;

import androidx.room.TypeConverter;

import java.util.Locale;


public class TypeConvertor {

    @TypeConverter
    public static Location stringAsLoc(String value) {
        if(value != null) {
            String[] values = value.split(" ");
            return new Location(values[0], values[1]);
        } else
            return null;
    }
    @TypeConverter
    public static String locAsString(Location location) {
        return location == null ? null : String.format(Locale.getDefault(),
                "%s %s",location.getLocality(),location.getCity());
    }


    @TypeConverter
    public static UserRating stringAsRating(String value) {
      return value == null ? null : new UserRating(value);
    }
    @TypeConverter
    public static String ratingAsString(UserRating location) {
        return location == null ? null : String.format(Locale.getDefault(), "%s",location.getAggregateRating());
    }

}
