package com.example.reisonlinemarket.ui.generalfragments;

import android.os.Bundle;

import androidx.constraintlayout.solver.PriorityGoalRow;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reisonlinemarket.R;
import com.example.reisonlinemarket.databinding.FragmentRecentlyProductsShowerBinding;
import com.example.reisonlinemarket.model.Product;
import com.squareup.picasso.Picasso;

public class RecentlyProductsShowerFragment extends Fragment {

    public static final String RPSF = "RPSF";
    private Product mProduct;
    private FragmentRecentlyProductsShowerBinding mViewBinding;
    private static SetListenerCallback mCallback;

    public static void setCallback(SetListenerCallback callback) {
        mCallback = callback;
    }

    public static RecentlyProductsShowerFragment newInstance(Product product) {
        RecentlyProductsShowerFragment fragment = new RecentlyProductsShowerFragment();
        Bundle args = new Bundle();
        args.putSerializable(RPSF, product);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProduct = (Product) getArguments().getSerializable(RPSF);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_recently_products_shower, container,false);
        initViews();
        setListener();
        return mViewBinding.getRoot();
    }

    private void initViews() {
        mViewBinding.setProduct(mProduct);
        Picasso.get().load(mProduct.getImageUrlList().get(0)).into(mViewBinding.imageOfProduct);
    }

    private void setListener(){
        mViewBinding.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onMainRowClick(mProduct);
            }
        });
    }

    public interface SetListenerCallback{
        void onMainRowClick(Product product);
    }
}