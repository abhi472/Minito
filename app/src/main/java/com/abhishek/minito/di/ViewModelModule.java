package com.abhishek.minito.di;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.abhishek.minito.ui.RestaurantListViewModel;
import com.abhishek.minito.ui.favorite.FavoriteActivityViewModel;
import com.abhishek.minito.ui.search.SearchViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
interface ViewModelModule {

    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel.class)
    ViewModel bindSearchViewModel(SearchViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteActivityViewModel.class)
    ViewModel bindFavoriteViewModel(FavoriteActivityViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RestaurantListViewModel.class)
    ViewModel bindFRestaurantListViewModel(RestaurantListViewModel viewModel);

}
