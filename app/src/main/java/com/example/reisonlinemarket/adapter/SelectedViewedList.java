package com.example.reisonlinemarket.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reisonlinemarket.R;
import com.example.reisonlinemarket.databinding.RowOfMostViewedListBinding;
import com.example.reisonlinemarket.model.Product;
import com.example.reisonlinemarket.ui.home.HomeFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SelectedViewedList {

//    private static OnClickCallback mCallback;
//
//    public static void setmCallback(OnClickCallback mCallback) {
//        SelectedViewedList.mCallback = mCallback;
//    }

    public static class ViewHolderClass extends RecyclerView.ViewHolder{

        private RowOfMostViewedListBinding mViewBinding;

        public ViewHolderClass(@NonNull RowOfMostViewedListBinding mBinding) {
            super(mBinding.getRoot());
            mViewBinding = mBinding;
        }

        public void bindView(Product product, Fragment fragment){
            mViewBinding.setProduct(product);
            mViewBinding.setHomeFragment((HomeFragment) fragment);
            Picasso.get().load(product.getImageUrlList().get(0)).into(mViewBinding.imageOfProductInMostViewed);
        }
    }

    public static class AdapterClass extends RecyclerView.Adapter<ViewHolderClass>{

        private RowOfMostViewedListBinding mBinding;
        private HomeFragment mHomeFragment;
        private List<Product> mProducts;

        public AdapterClass(Fragment fragment, List<Product> products) {
            mHomeFragment = (HomeFragment) fragment;
            mProducts = products;
        }

        @NonNull
        @Override
        public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            mBinding =
                    DataBindingUtil
                            .inflate(
                                    LayoutInflater.from(mHomeFragment.getContext()),
                                    R.layout.row_of_most_viewed_list,
                                    parent,
                                    false);
            ViewHolderClass viewHolderClass = new ViewHolderClass(mBinding);
            return viewHolderClass;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
            holder.bindView(mProducts.get(position), mHomeFragment);
        }

        @Override
        public int getItemCount() {
            return mProducts.size();
        }
    }

//    public interface OnClickCallback{
//        void onMainRowClick(Product product);
//    }

}
