package com.abhishek.minito.ui.search;

import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.abhishek.minito.BuildConfig;
import com.abhishek.minito.R;
import com.abhishek.minito.SingleLiveEvent;
import com.abhishek.minito.data.BaseCommand;
import com.abhishek.minito.model.Cuisine;
import com.abhishek.minito.model.Restaurant;
import com.abhishek.minito.model.RestaurantInner;
import com.abhishek.minito.model.ZomatoSearchBody;
import com.abhishek.minito.repository.ApiRepository;
import com.abhishek.minito.repository.ApiRepositoryHelper;
import com.abhishek.minito.ui.BaseViewModel;
import com.google.android.gms.common.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class SearchViewModel extends BaseViewModel {

    private ApiRepository repository;
    private String searchText;


    SingleLiveEvent<BaseCommand> liveEvent = new SingleLiveEvent<>();


    public ObservableField<Integer> noDataText = new ObservableField<>(R.string.no_searches_history_found_nstart_searching);
    public ObservableField<Boolean> noDataVisibility = new ObservableField<>(true);
    public ObservableField<Boolean> listVisibility = new ObservableField<>(false);
    public ObservableField<Boolean> sortVisibility = new ObservableField<>(false);

    private List<Cuisine> cuisines = new ArrayList<>();
    private String sort = "";
    private String searchedText="";


    @Inject
    public SearchViewModel(ApiRepositoryHelper repository) {
        this.repository = repository;

    }

    public void fetchCuisines() {
        getCompositeDisposable()
                .add(repository.getCuisines(BuildConfig.API_KEY,
                        "28.7041° N", " 77.1025° E")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(restaurantInnerList -> {

                            this.cuisines = restaurantInnerList.getCuisines();

                        }, throwable -> {
                            liveEvent.setValue(new BaseCommand.Error(R.string.no_search_result_found));

                        })
                );
    }


    public void onTextChanged(CharSequence s, int before, int after, int count) {

        searchText = s.toString();
    }

    public void updateSort(boolean flag) {
        sort = flag ? "rating" : "";
        sortVisibility.set(flag);
        searchText = searchedText;
        if(!TextUtils.isEmpty(searchText)) {
            onEditorAction();
        }


    }

    public void onEditorAction() {
        noDataVisibility.set(true);
        noDataText.set(R.string.searching);
        listVisibility.set(false);
        getCompositeDisposable().add(
                repository.getRestaurants(BuildConfig.API_KEY,
                        searchText,
                        sort, "28.7041° N", " 77.1025° E")
                        .flatMap((Function<ZomatoSearchBody,
                                ObservableSource<List<RestaurantInner>>>) zomatoSearchBody ->
                                mapActualData(zomatoSearchBody.getRestaurants()))
                        .concatMap((Function<List<RestaurantInner>, ObservableSource<List<Object>>>) this::mapFinalData)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(restaurantInnerList -> {

                            if (CollectionUtils.isEmpty(restaurantInnerList)) {
                                noDataText.set(R.string.no_search_result_found);
                                noDataVisibility.set(true);
                            } else {
                                searchedText = searchText;
                                liveEvent.setValue(new
                                        BaseCommand.Success(restaurantInnerList));
                                noDataVisibility.set(false);
                                listVisibility.set(true);
                            }

                        }, throwable -> {
                            noDataVisibility.set(true);
                            noDataText.set(R.string.no_search_result_found);
                            liveEvent.setValue(new BaseCommand.Error(R.string.no_search_result_found));

                        })
        );
    }

    private Observable<List<RestaurantInner>> mapActualData(List<Restaurant> restaurants) {
        return Observable.fromCallable(() -> fetchRestaurantsFromThisGibberData(restaurants));
    }

    private List<RestaurantInner> fetchRestaurantsFromThisGibberData(List<Restaurant> restaurants) {

        List<RestaurantInner> restaurantInners = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            restaurantInners.add(restaurant.getRestaurant());
        }

        return restaurantInners;
    }

    private Observable<List<Object>> mapFinalData(List<RestaurantInner> restaurants) {
        return Observable.fromCallable(() -> cuisineSortedDate(restaurants));
    }


    private List<Object> cuisineSortedDate(List<RestaurantInner> inners) {
        List<Object> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(cuisines)) {
            list.addAll(inners);
        } else {
            for (int i = 0; i < cuisines.size(); i++) {
                int count = 0;
                if (CollectionUtils.isEmpty(inners))
                    break;
                for (int j = 0; j < inners.size(); j++) {
                    if (inners.get(j).getCuisines().contains(cuisines.get(i).getCuisine().getCuisineName())) {

                        if (count == 0) {
                            list.add(cuisines.get(i).getCuisine().getCuisineName());
                            count++;
                        }
                        list.add(inners.get(j));
                        inners.remove(j);
                    }
                }
            }
        }

        return list;
    }
}



