package com.abhishek.minito.ui;

import android.os.Bundle;

import dagger.android.AndroidInjection;
import dagger.android.DaggerActivity;
import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity extends DaggerAppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
    }


    void renderViewState(ViewState viewState) {
        if(viewState != null) {
            boolean bool = viewState.isLoading;
            if (bool)
                showProgress();
            else hideProgress();
        }
    }

    void hideProgress() {

    }

    void showProgress() {

    }


}

