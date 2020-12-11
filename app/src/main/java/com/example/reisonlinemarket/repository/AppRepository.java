package com.example.reisonlinemarket.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.reisonlinemarket.model.Product;
import com.example.reisonlinemarket.network.QueryParameters;
import com.example.reisonlinemarket.network.RetrofitInstance;
import com.example.reisonlinemarket.network.ServerService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {

    private static final String TAG = "retag";
    public static AppRepository sAppRepository;

    public static AppRepository getInstance() {
        if (sAppRepository == null) {
            sAppRepository = new AppRepository();
        }
        return sAppRepository;
    }

    private ServerService mServerService;
    private MutableLiveData<List<Product>> mLiveProductList = new MutableLiveData<>();
    private MutableLiveData<List<Product>> mLiveMostViewedList = new MutableLiveData<>();
    private MutableLiveData<List<Product>> mLiveHighScoreList = new MutableLiveData<>();

    private AppRepository() {
        mServerService = RetrofitInstance.getInstance().create(ServerService.class);
    }

    public LiveData<List<Product>> GetProductList() {
        Call<List<Product>> listCall =
                mServerService.getProductList(QueryParameters.ProductQueryParameters);
        listCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Log.d(TAG, "response size= " + response.body().size());
                mLiveProductList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
            }
        });
        return mLiveProductList;
    }

    public LiveData<List<Product>> getMostViewedProductList() {
        Call<List<Product>> listCall =
                mServerService.getSelectedProductList(QueryParameters.MostViewedProductQueryParameters);
        listCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mLiveMostViewedList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
        return mLiveMostViewedList;
    }

    public LiveData<List<Product>> getHighScoreProductList(){
        Call<List<Product>> listCall =
                mServerService.getSelectedProductList(QueryParameters.HighScoreProductQueryParameters);
        listCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mLiveHighScoreList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
        return mLiveHighScoreList;
    }
}
