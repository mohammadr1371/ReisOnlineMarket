package com.example.reisonlinemarket.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.reisonlinemarket.R;
import com.example.reisonlinemarket.adapter.SelectedViewedList;
import com.example.reisonlinemarket.adapter.RecentlyViewPagerList;
import com.example.reisonlinemarket.databinding.FragmentHomeBinding;
import com.example.reisonlinemarket.model.Product;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mViewBinding;
    private HomeViewModel homeViewModel;
    private NavController mNavController;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_home, container, false);
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        initObserver();

        return mViewBinding.getRoot();
    }

    private void initObserver() {
        homeViewModel.getProductList().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                initViewPagerAdapter(products);
            }
        });

        homeViewModel.getMostViewedList().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                initMostViewedList(products);
            }
        });

        homeViewModel.getHighScoreList().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                initHighScoreList(products);
            }
        });
    }

    public void initMostViewedList(List<Product> products) {
        mViewBinding.topViewList.setLayoutManager(
                new LinearLayoutManager(getActivity()
                        , LinearLayoutManager.HORIZONTAL
                        , true));
        mViewBinding.topViewList.setAdapter(new SelectedViewedList.AdapterClass(getActivity(), products));
    }

    public void initViewPagerAdapter(List<Product> products) {
        mViewBinding.recentlyList.setAdapter(new RecentlyViewPagerList(getActivity(), products));
    }

    public void initHighScoreList(List<Product> products){
        mViewBinding.highScoreList.setLayoutManager(
                new LinearLayoutManager(getActivity()
                , LinearLayoutManager.HORIZONTAL
                ,true));
        mViewBinding.highScoreList.setAdapter(new SelectedViewedList.AdapterClass(getActivity(), products));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}