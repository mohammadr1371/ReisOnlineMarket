package com.example.reisonlinemarket.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.reisonlinemarket.model.Product;
import com.example.reisonlinemarket.ui.generalfragments.RecentlyProductsShowerFragment;
import com.example.reisonlinemarket.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class RecentlyViewPagerList extends FragmentStateAdapter {

    private ArrayList<Product> mProducts;

    public RecentlyViewPagerList(@NonNull FragmentActivity fragmentActivity, List<Product> products) {
        super(fragmentActivity);
        mProducts = (ArrayList<Product>) products;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = RecentlyProductsShowerFragment.newInstance(mProducts.get(position));
        return fragment;
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }
}
