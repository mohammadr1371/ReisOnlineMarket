package com.example.reisonlinemarket.ui.generalfragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reisonlinemarket.R;
import com.example.reisonlinemarket.adapter.ImagePager;
import com.example.reisonlinemarket.databinding.FragmentDetailProductBinding;
import com.example.reisonlinemarket.model.Product;

public class DetailProductFragment extends Fragment {

    private FragmentDetailProductBinding mViewBinding;
    private Product mProduct;

    public FragmentDetailProductBinding getViewBinding() {
        return mViewBinding;
    }

    public static DetailProductFragment newInstance() {
        DetailProductFragment fragment = new DetailProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProduct = (Product) getArguments().getSerializable("product");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_detail_product, container, false);
        initViews();
        return mViewBinding.getRoot();
    }

    private void initViews(){
        mViewBinding.setProduct(mProduct);
        mViewBinding.productImagePager.setAdapter(new ImagePager(getActivity(), mProduct.getImageUrlList()));


    }
}