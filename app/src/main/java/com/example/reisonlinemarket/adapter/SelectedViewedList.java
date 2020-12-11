package com.example.reisonlinemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reisonlinemarket.R;
import com.example.reisonlinemarket.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SelectedViewedList {

    public static class ViewHolderClass extends RecyclerView.ViewHolder{
        private ImageView mImageOfProduct;
        private TextView mTitle;
        private TextView mRegularPrice;
        private TextView mSalePrice;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            mImageOfProduct = itemView.findViewById(R.id.image_of_product_in_most_viewed);
            mTitle = itemView.findViewById(R.id.product_title_in_most_viewed);
            mRegularPrice = itemView.findViewById(R.id.regular_price_in_most_viewed);
            mSalePrice = itemView.findViewById(R.id.sale_price_in_most_viewed);
        }

        public void bindView(Product product){
            mTitle.setText(product.getName());
            mRegularPrice.setText(product.getRegularPrice());
            mSalePrice.setText(product.getSalePrice());
            Picasso.get().load(product.getImageUrlList().get(0)).into(mImageOfProduct);
        }
    }

    public static class AdapterClass extends RecyclerView.Adapter<ViewHolderClass>{

        private Context mContext;
        private List<Product> mProducts;

        public AdapterClass(Context context, List<Product> products) {
            mContext = context.getApplicationContext();
            mProducts = products;
        }

        @NonNull
        @Override
        public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext)
                    .inflate(R.layout.row_of_most_viewed_list, parent,false);
            ViewHolderClass viewHolderClass = new ViewHolderClass(view);
            return viewHolderClass;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
            holder.bindView(mProducts.get(position));
        }

        @Override
        public int getItemCount() {
            return mProducts.size();
        }
    }

}
