package com.example.reisonlinemarket.network;

import android.util.Log;

import com.example.reisonlinemarket.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static String BASE_URL = "https://woocommerce.maktabsharif.ir/wp-json/wc/v3/";

    public static Retrofit sRetrofit;

    public static Retrofit getInstance() {
        if(sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(customizedGsonConverterFactory())
            .build();
        }
        return sRetrofit;
    }

    public static Converter.Factory customizedGsonConverterFactory(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new TypeToken<List<Product>>(){}.getType()
                ,new CustomGsonRetrofitConverter());
        Gson gson = gsonBuilder.create();
        return GsonConverterFactory.create(gson);
    }
}
