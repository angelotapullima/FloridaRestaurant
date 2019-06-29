package com.bufeotec.floridarestaurant.MVVM.Views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bufeotec.floridarestaurant.R;
public class ReservarMesaFragment extends Fragment {


    public ReservarMesaFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reservar_mesa, container, false);

        return view;
    }



}
