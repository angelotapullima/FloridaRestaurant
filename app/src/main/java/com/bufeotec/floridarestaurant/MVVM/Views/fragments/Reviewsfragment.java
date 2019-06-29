package com.bufeotec.floridarestaurant.MVVM.Views.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bufeotec.floridarestaurant.MVVM.Models.Reviews;
import com.bufeotec.floridarestaurant.MVVM.ViewModels.Reviews.ReviewListViewModel;
import com.bufeotec.floridarestaurant.MVVM.Views.Adapters.ReviewListAdapter;
import com.bufeotec.floridarestaurant.R;

import java.util.List;

public class Reviewsfragment extends Fragment {


    ReviewListViewModel reviewListViewModel;
    ReviewListAdapter reviewListAdapter;
    RecyclerView rcv_reviews;
    public Reviewsfragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //    progressDialog = new ProgressDialog(getActivity());
        reviewListViewModel = ViewModelProviders.of(getActivity()).get(ReviewListViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reviewsfragment, container, false);

        initViews(view);
        setAdapter();

        reviewListViewModel.getmAllReviews().observe(this, new Observer<List<Reviews>>() {
            @Override
            public void onChanged(@Nullable List<Reviews> listaReviews) {
                reviewListAdapter.setWords(listaReviews);

            }
        });
        return  view;
    }

    private void initViews(View view){
        rcv_reviews=view.findViewById(R.id.rcv_reviews);
    }



    private void setAdapter(){
        reviewListAdapter = new ReviewListAdapter(getActivity());
        rcv_reviews.setAdapter(reviewListAdapter);
        rcv_reviews.setLayoutManager(new LinearLayoutManager(getActivity()));




    }
}
