package com.bufeotec.floridarestaurant.MVVM.Views.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bufeotec.floridarestaurant.MVVM.Models.Reviews;
import com.bufeotec.floridarestaurant.R;
import com.bufeotec.floridarestaurant.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ReviewsViewHolder> {

    UniversalImageLoader universalImageLoader;


    class ReviewsViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, descripcion;
        ImageView foto;

        private ReviewsViewHolder(View itemView) {
            super(itemView);
            nombre= itemView.findViewById(R.id.review_nombre);
            descripcion= itemView.findViewById(R.id.review_descripcion);
            foto= itemView.findViewById(R.id.review_foto);

        }
    }

    private final LayoutInflater mInflater;
    private List<Reviews> listaReview; // Cached copy of users


    public ReviewListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        universalImageLoader = new UniversalImageLoader(context);}

    @NonNull
    @Override
    public ReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.rcv_reviews, parent, false);
        return new ReviewsViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ReviewsViewHolder holder, int position) {
        if (listaReview != null) {
            Reviews current = listaReview.get(position);

            ImageLoader.getInstance().init(universalImageLoader.getConfig());
            UniversalImageLoader.setImage(current.getReview_foto(),holder.foto,null);
            holder.nombre.setText(current.getReview_nombre());
            holder.descripcion.setText(current.getReview_descripcion());




        } else {
            // Covers the case of data not being ready yet.
            // holder.userNameView.setText("No Word");
        }
    }


    public void setWords(List<Reviews> reviews){
        listaReview = reviews;
        notifyDataSetChanged();
    }

    /*void setWords(List<Reviews> users){
        listaReview = users;
        notifyDataSetChanged();
    }*/

    @Override
    public int getItemCount() {
        if (listaReview != null) {
            return listaReview.size();
        }else{
            return  0;
        }
    }
}
