package com.example.reisonlinemarket.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    private int mId;
    private String mName;
//    private String mStatus;
//    private String mDescription;
    private String mRegularPrice;
    private String mSalePrice;
    private String mWeight;
//    private Dimensions mDimensions;
//    private List<Categories> mCategoriesList;
    private List<String> mImageUrlList;

    public Product(int id
            , String name
            , String regularPrice
            , String salePrice
            , List<String> imageUrlList) {
        mId = id;
        mName = name;
        mRegularPrice = regularPrice;
        mSalePrice = salePrice;
        mImageUrlList = imageUrlList;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getRegularPrice() {
        return mRegularPrice;
    }

    public String getSalePrice() {
        return mSalePrice;
    }

    public String getWeight() {
        return mWeight;
    }



    public List<String> getImageUrlList() {
        return mImageUrlList;
    }

    public static class Dimensions {
        private String mWidth;
        private String mLength;
        private String mHeight;

        public Dimensions(String width, String length, String height) {
            mWidth = width;
            mLength = length;
            mHeight = height;
        }

        public String getWidth() {
            return mWidth;
        }

        public void setWidth(String width) {
            mWidth = width;
        }

        public String getLength() {
            return mLength;
        }

        public void setLength(String length) {
            mLength = length;
        }

        public String getHeight() {
            return mHeight;
        }

        public void setHeight(String height) {
            mHeight = height;
        }
    }

    public static class Categories{
        private int mCategoryId;
        private String mCategoryName;
        private String mCategorySlug;

        public Categories(int categoryId, String categoryName, String categorySlug) {
            mCategoryId = categoryId;
            mCategoryName = categoryName;
            mCategorySlug = categorySlug;
        }

        public int getCategoryId() {
            return mCategoryId;
        }

        public void setCategoryId(int categoryId) {
            mCategoryId = categoryId;
        }

        public String getCategoryName() {
            return mCategoryName;
        }

        public void setCategoryName(String categoryName) {
            mCategoryName = categoryName;
        }

        public String getCategorySlug() {
            return mCategorySlug;
        }

        public void setCategorySlug(String categorySlug) {
            mCategorySlug = categorySlug;
        }
    }
}
