package com.example.reisonlinemarket.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.reisonlinemarket.adapter.RecentlyViewPagerList;
import com.example.reisonlinemarket.model.Product;
import com.example.reisonlinemarket.repository.AppRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private LiveData<List<Product>> mProductList;
    private LiveData<List<Product>> mMostViewedList;
    private LiveData<List<Product>> mHighScoreList;
    private AppRepository mAppRepository;

    public LiveData<List<Product>> getHighScoreList() {
        mHighScoreList = mAppRepository.getHighScoreProductList();
        return mHighScoreList;
    }

    public LiveData<List<Product>> getProductList() {
        mProductList = mAppRepository.GetProductList();
        return mProductList;
    }

    public LiveData<List<Product>> getMostViewedList() {
        mMostViewedList = mAppRepository.getMostViewedProductList();
        return mMostViewedList;
    }

    public HomeViewModel() {
        mAppRepository = AppRepository.getInstance();
    }
}