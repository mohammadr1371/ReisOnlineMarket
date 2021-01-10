package com.example.reisonlinemarket.network;

import com.example.reisonlinemarket.model.Category;
import com.example.reisonlinemarket.model.Product;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ServerService {

    @GET("products")
    Call<List<Product>> getProductList(@QueryMap Map<String, String> queryParameters);

    @GET("products/category")
    Call<List<Category>> getCategoryList();
}
