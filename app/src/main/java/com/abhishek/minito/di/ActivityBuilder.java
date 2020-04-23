package com.abhishek.minito.di;


import com.abhishek.minito.ui.favorite.FavoriteActivity;
import com.abhishek.minito.ui.favorite.FavoriteActivityModule;
import com.abhishek.minito.ui.search.SearchActivity;
import com.abhishek.minito.ui.search.SearchActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = SearchActivityModule.class)
    abstract SearchActivity contributeSearchInjector();


    @ContributesAndroidInjector(modules = FavoriteActivityModule.class)
    abstract FavoriteActivity contributeFavoriteInjector();


}
