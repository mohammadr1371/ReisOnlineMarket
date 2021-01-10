package com.example.reisonlinemarket.ui.generalfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.reisonlinemarket.R;
import com.squareup.picasso.Picasso;

public class ImageShowerFragment extends Fragment {

    public static final String IMAGE_URL = "image url";

    private String mImageUrl;
    private ImageView mImageContainer;

    public static ImageShowerFragment newInstance(String url) {
        ImageShowerFragment fragment = new ImageShowerFragment();
        Bundle args = new Bundle();
        args.putString(IMAGE_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageUrl = getArguments().getString(IMAGE_URL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_shower, container, false);
        mImageContainer = view.findViewById(R.id.image_container);
        Picasso.get().load(mImageUrl).into(mImageContainer);
        return view;
    }
}