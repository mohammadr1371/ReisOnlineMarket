package com.example.reisonlinemarket.network;

import android.media.session.MediaSession;
import android.util.Log;

import com.example.reisonlinemarket.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomGsonRetrofitConverter implements JsonDeserializer<List<Product>> {


    private static final String TAG = "tag2" ;

    @Override
    public List<Product> deserialize
            (JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Log.d(TAG, "avale deserialize");
        List<Product> productList = new ArrayList<>();
        JsonArray jsonArrayBody = json.getAsJsonArray();
        Log.d(TAG, "ghabl az for aval");
        for (int i = 0; i<jsonArrayBody.size(); i++){
            JsonObject productObject = jsonArrayBody.get(i).getAsJsonObject();
            int id = productObject.get("id").getAsInt();
            String name = productObject.get("name").getAsString();
            String status = productObject.get("status").getAsString();
            String description = productObject.get("description").getAsString();
            String regularPrice = productObject.get("regular_price").getAsString();
            String salePrice = productObject.get("sale_price").getAsString();
            String weight = productObject.get("weight").getAsString();
            JsonObject dimensionsObject = productObject.get("dimensions").getAsJsonObject();
            String length = dimensionsObject.get("length").getAsString();
            String width = dimensionsObject.get("width").getAsString();
            String height = dimensionsObject.get("height").getAsString();
            JsonArray categoryJsonArray = productObject.get("categories").getAsJsonArray();
            List<Product.Categories> categoriesList = new ArrayList<>();
            for (int j = 0; j<categoryJsonArray.size(); j++){
                JsonObject categoryObject = categoryJsonArray.get(j).getAsJsonObject();
                int categoryId = categoryObject.get("id").getAsInt();
                String categoryName = categoryObject.get("name").getAsString();
                String categorySlug = categoryObject.get("slug").getAsString();
                Product.Categories category = new Product.Categories(categoryId, categoryName, categorySlug);
                categoriesList.add(category);
            }
            Log.d(TAG, "ghabl az for aks");
            List<String> imageUrlList = new ArrayList<>();
            JsonArray imageJsonArray = productObject.get("images").getAsJsonArray();
            if(imageJsonArray.size() == 0 || imageJsonArray == null){
                continue;
            }
            for (int j = 0; j<imageJsonArray.size(); j++){
                JsonObject imageObject = imageJsonArray.get(j).getAsJsonObject();
                String imageUrl = imageObject.get("src").getAsString();
                imageUrlList.add(imageUrl);
            }
            Log.d(TAG, "bad az for aks");
            Product product = new Product(
                    id,
                    name,
                    status,
                    description,
                    regularPrice,
                    salePrice,
                    weight,
                    new Product.Dimensions(width, length, height),
                    categoriesList,
                    imageUrlList);
            productList.add(product);
            Log.d(TAG, "bad az sakhte model"+ product.getName());
        }

        Log.d(TAG, "ghabl az return");
        return productList;
    }
}
