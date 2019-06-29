package com.bufeotec.floridarestaurant.MVVM.Views.fragments;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bufeotec.floridarestaurant.MVVM.Models.ListaPlatos;
import com.bufeotec.floridarestaurant.MVVM.Models.Menu;
import com.bufeotec.floridarestaurant.MVVM.ViewModels.Menu.MenuListViewModel;
import com.bufeotec.floridarestaurant.MVVM.ViewModels.Platos.ListPlatosViewModel;
import com.bufeotec.floridarestaurant.MVVM.Views.Adapters.MenuListAdapter;
import com.bufeotec.floridarestaurant.MVVM.Views.Adapters.PlatosListAdapter;
import com.bufeotec.floridarestaurant.R;

import java.util.List;


public class FragmentRestaurant extends Fragment {



    ListPlatosViewModel listPlatosViewModel;
    MenuListViewModel listMenuViewModel;
    PlatosListAdapter platosListAdapter = null;
    MenuListAdapter menuListAdapter= null;

    Activity activity;
    Context context;
    RecyclerView rcv_misAtenciones,rcv_menu;

    public FragmentRestaurant() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //    progressDialog = new ProgressDialog(getActivity());
        listMenuViewModel = ViewModelProviders.of(getActivity()).get(MenuListViewModel.class);
        listPlatosViewModel = ViewModelProviders.of(getActivity()).get(ListPlatosViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);

        activity = getActivity();
        context = getContext();






        initViews(view);
        setAdapter();

        listPlatosViewModel.getAllPosts().observe(this, new Observer<List<ListaPlatos>>() {
            @Override
            public void onChanged(@Nullable List<ListaPlatos> listaPlatos) {
                platosListAdapter.setWords(listaPlatos);

            }
        });
        listMenuViewModel.getAllMenuss().observe(this, new Observer<List<Menu>>() {
            @Override
            public void onChanged(@Nullable List<Menu> menu) {
                menuListAdapter.setWords(menu);

            }
        });



        return view;
    }

    private void initViews(View view){
        rcv_misAtenciones=view.findViewById(R.id.rcv_misatenciones);
        rcv_menu=view.findViewById(R.id.rcv_menu);
    }



    private void setAdapter(){
        platosListAdapter = new PlatosListAdapter(getActivity());
        rcv_misAtenciones.setAdapter(platosListAdapter);
        rcv_misAtenciones.setLayoutManager(new LinearLayoutManager(getActivity()));



        menuListAdapter = new MenuListAdapter(getActivity());
        LinearLayoutManager layoutManager =  new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(layoutManager.HORIZONTAL);

        rcv_menu.setLayoutManager(layoutManager);
        rcv_menu.setAdapter(menuListAdapter);
    }






}
