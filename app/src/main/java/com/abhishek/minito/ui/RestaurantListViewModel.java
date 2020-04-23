package com.abhishek.minito.ui;

import androidx.databinding.ObservableField;

import com.abhishek.minito.model.RestaurantInner;
import com.abhishek.minito.repository.DatabaseRepository;

import java.util.Locale;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RestaurantListViewModel extends BaseViewModel {

    private final DatabaseRepository repository;

    public ObservableField<Boolean> progressVisibilty = new ObservableField<>(false);
    public ObservableField<Boolean> favVisibility = new ObservableField<>(true);
    public ObservableField<Boolean> unFavVisibility = new ObservableField<>(false);


    @Inject
    public RestaurantListViewModel(DatabaseRepository repository) {
        this.repository = repository;
    }

    public String setPriceForTwo(int price) {

        return String.format(Locale.getDefault(), "Rs. %d for two", price);
    }

    public void checkFavorite(RestaurantInner restaurantInner) {

        favVisibility.set(false);
        progressVisibilty.set(true);

        getCompositeDisposable().add(saveFav(restaurantInner)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(aLong -> {

                    unFavVisibility.set(true);
                    progressVisibilty.set(false);

                }, throwable -> {
                    progressVisibilty.set(false);
                    favVisibility.set(true);


                })
        );
    }



    private Observable<Long> saveFav(RestaurantInner restaurantInner) {
        return Observable.fromCallable(() -> repository.saveRestaurant(restaurantInner));
    }


    public void onClick() {

    }
}
