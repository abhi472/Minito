
package com.abhishek.minito.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "restaurants")
public class RestaurantInner implements Parcelable
{

    @SerializedName("apikey")
    @Expose
    @Ignore
    private String apikey;
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    @NonNull
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("cuisines")
    @Expose
    private String cuisines;
    @SerializedName("timings")
    @Expose
    private String timings;
    @SerializedName("average_cost_for_two")
    @Expose
    private Integer averageCostForTwo;
    @SerializedName("price_range")
    @Expose
    private Integer priceRange;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("user_rating")
    @Expose
    private UserRating userRating;
    @SerializedName("all_reviews_count")
    @Expose
    private Integer allReviewsCount;
    @SerializedName("photos_url")
    @Expose
    private String photosUrl;
    @SerializedName("photo_count")
    @Expose
    private Integer photoCount;
    @SerializedName("menu_url")
    @Expose
    private String menuUrl;
    @SerializedName("featured_image")
    @Expose
    private String featuredImage;
    @SerializedName("is_delivering_now")
    @Expose
    private Integer isDeliveringNow;

    @SerializedName("phone_numbers")
    @Expose
    private String phoneNumbers;

    public final static Creator<RestaurantInner> CREATOR = new Creator<RestaurantInner>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RestaurantInner createFromParcel(Parcel in) {
            return new RestaurantInner(in);
        }

        public RestaurantInner[] newArray(int size) {
            return (new RestaurantInner[size]);
        }

    }
    ;

    protected RestaurantInner(Parcel in) {
        this.apikey = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        this.cuisines = ((String) in.readValue((String.class.getClassLoader())));
        this.timings = ((String) in.readValue((String.class.getClassLoader())));
        this.averageCostForTwo = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.priceRange = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.currency = ((String) in.readValue((String.class.getClassLoader())));

        this.thumb = ((String) in.readValue((String.class.getClassLoader())));
        this.userRating = ((UserRating) in.readValue((UserRating.class.getClassLoader())));
        this.allReviewsCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.photosUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.photoCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.menuUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.featuredImage = ((String) in.readValue((String.class.getClassLoader())));
        this.isDeliveringNow = ((Integer) in.readValue((Integer.class.getClassLoader())));

        this.phoneNumbers = ((String) in.readValue((String.class.getClassLoader())));
    }

    public RestaurantInner() {
    }


    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public Integer getAverageCostForTwo() {
        return averageCostForTwo;
    }

    public void setAverageCostForTwo(Integer averageCostForTwo) {
        this.averageCostForTwo = averageCostForTwo;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

     public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public UserRating getUserRating() {
        return userRating;
    }

    public void setUserRating(UserRating userRating) {
        this.userRating = userRating;
    }

    public Integer getAllReviewsCount() {
        return allReviewsCount;
    }

    public void setAllReviewsCount(Integer allReviewsCount) {
        this.allReviewsCount = allReviewsCount;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public void setPhotosUrl(String photosUrl) {
        this.photosUrl = photosUrl;
    }

    public Integer getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(Integer photoCount) {
        this.photoCount = photoCount;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(String featuredImage) {
        this.featuredImage = featuredImage;
    }



    public Integer getIsDeliveringNow() {
        return isDeliveringNow;
    }

    public void setIsDeliveringNow(Integer isDeliveringNow) {
        this.isDeliveringNow = isDeliveringNow;
    }


    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(apikey);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(url);
        dest.writeValue(location);
        dest.writeValue(cuisines);
        dest.writeValue(timings);
        dest.writeValue(averageCostForTwo);
        dest.writeValue(priceRange);
        dest.writeValue(currency);

        dest.writeValue(thumb);
        dest.writeValue(userRating);
        dest.writeValue(allReviewsCount);
        dest.writeValue(photosUrl);
        dest.writeValue(photoCount);
        dest.writeValue(menuUrl);
        dest.writeValue(featuredImage);
        dest.writeValue(isDeliveringNow);
        dest.writeValue(phoneNumbers);
    }

    public int describeContents() {
        return  0;
    }

}
