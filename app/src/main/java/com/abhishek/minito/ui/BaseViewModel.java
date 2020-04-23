package com.abhishek.minito.ui;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    public MutableLiveData<ViewState> viewState = new MutableLiveData<>();



    private CompositeDisposable disposable = new CompositeDisposable();


    public BaseViewModel() {
    }


    public CompositeDisposable getCompositeDisposable() {
        return disposable;
    }

    public void showProgressBar() {
        viewState.setValue(new ViewState(true));
    }

    public void hideProgressBar() {
        viewState.setValue(new ViewState(false));
    }

    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }
}
