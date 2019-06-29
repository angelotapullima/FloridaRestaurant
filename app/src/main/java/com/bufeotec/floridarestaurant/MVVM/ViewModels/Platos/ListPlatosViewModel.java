package com.bufeotec.floridarestaurant.MVVM.ViewModels.Platos;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;


import com.bufeotec.floridarestaurant.MVVM.Models.ListaPlatos;
import com.bufeotec.floridarestaurant.MVVM.Repository.platos.ListPlatosRoomDBRepository;
import com.bufeotec.floridarestaurant.MVVM.Repository.platos.ListPlatosWebServiceRepository;

import java.util.List;

public class ListPlatosViewModel extends AndroidViewModel {

    private ListPlatosRoomDBRepository listPlatosRoomDBRepository;

    private LiveData<List<ListaPlatos>> mAllPosts;

    ListPlatosWebServiceRepository listPlatosWebServiceRepository;

    private final LiveData<List<ListaPlatos>> retroObservable;


    public ListPlatosViewModel(Application application){
        super(application);
        listPlatosRoomDBRepository = new ListPlatosRoomDBRepository(application);
        listPlatosWebServiceRepository = new ListPlatosWebServiceRepository(application);
        retroObservable = listPlatosWebServiceRepository.providesWebService();
        //listPlatosRoomDBRepository.insertPosts(retroObservable.getValue());
        mAllPosts = listPlatosRoomDBRepository.getAllPosts();
    }

    public LiveData<List<ListaPlatos>> getAllPosts() {
        return mAllPosts;
    }

   /* public LiveData<List<ListaPlatos>> getProjectRetroListObservable() {
        return retroObservable;
    }*/

/*    public void insert(User user) {
        userRepository.insert(user);
    }*/
}
