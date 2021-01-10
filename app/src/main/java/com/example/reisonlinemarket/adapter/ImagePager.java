package com.example.reisonlinemarket.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.reisonlinemarket.ui.generalfragments.ImageShowerFragment;

import java.util.List;

public class ImagePager extends FragmentStateAdapter {

    private List<String> mImageUrlList;

    public ImagePager(@NonNull FragmentActivity fragmentActivity, List<String> imageUrlList) {
        super(fragmentActivity);
        mImageUrlList = imageUrlList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = ImageShowerFragment.newInstance(mImageUrlList.get(position));
        return fragment;
    }

    @Override
    public int getItemCount() {
        return mImageUrlList.size();
    }
}
