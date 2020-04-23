package com.abhishek.minito.ui.favorite;

import androidx.databinding.ObservableField;

import com.abhishek.minito.BuildConfig;
import com.abhishek.minito.R;
import com.abhishek.minito.SingleLiveEvent;
import com.abhishek.minito.data.BaseCommand;
import com.abhishek.minito.model.Cuisine;
import com.abhishek.minito.model.Restaurant;
import com.abhishek.minito.model.RestaurantInner;
import com.abhishek.minito.model.ZomatoSearchBody;
import com.abhishek.minito.repository.ApiRepositoryHelper;
import com.abhishek.minito.repository.DatabaseRepository;
import com.abhishek.minito.repository.DatabaseRepositoryHelper;
import com.abhishek.minito.ui.BaseViewModel;
import com.google.android.gms.common.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class FavoriteActivityViewModel extends BaseViewModel {

    private DatabaseRepository repository;


    public ObservableField<Boolean> noDataVisibility = new ObservableField<>(true);
    public ObservableField<Boolean> listVisibility = new ObservableField<>(false);

    @Inject
    public FavoriteActivityViewModel(DatabaseRepositoryHelper repository) {
        this.repository = repository;

    }


    SingleLiveEvent<BaseCommand> liveEvent = new SingleLiveEvent<>();


    public void fetchDbData() {

        getCompositeDisposable().add(repository.getRestaurants()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(restaurantInnerList -> {

                    if (!CollectionUtils.isEmpty(restaurantInnerList)) {
                        liveEvent.setValue(new
                                BaseCommand.Success(restaurantInnerList));
                        noDataVisibility.set(false);
                        listVisibility.set(true);
                    }

                }, throwable -> {
                        liveEvent.setValue(new BaseCommand.Error(R.string.no_search_result_found));

                    })
        );


    }
}
