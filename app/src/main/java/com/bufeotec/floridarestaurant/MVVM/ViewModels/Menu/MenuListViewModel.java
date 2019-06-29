package com.bufeotec.floridarestaurant.MVVM.ViewModels.Menu;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.bufeotec.floridarestaurant.MVVM.Models.Menu;
import com.bufeotec.floridarestaurant.MVVM.Repository.MenuHorizontal.MenuWebServiceRepository;
import com.bufeotec.floridarestaurant.MVVM.Repository.MenuHorizontal.MenuRoomDBRepository;

import java.util.List;

public class MenuListViewModel extends AndroidViewModel {

    private MenuRoomDBRepository menuRoomDBRepository;
    private LiveData<List<Menu>> mAllMenu;
    MenuWebServiceRepository menuWebServiceRepository;
    private final LiveData<List<Menu>> retroObservable;
    public MenuListViewModel(Application application){
        super(application);
        menuRoomDBRepository = new MenuRoomDBRepository(application);
        menuWebServiceRepository = new MenuWebServiceRepository(application);
        retroObservable = menuWebServiceRepository.providesWebService();
        //menuRoomDBRepository.insertPosts(retroObservable.getValue());
        mAllMenu = menuRoomDBRepository.getAllMenues();
    }

    public LiveData<List<Menu>> getAllMenuss() {
        return mAllMenu;
    }

   /* public LiveData<List<ResultModel>> getProjectRetroListObservable() {
        return retroObservable;
    }*/

/*    public void insert(User user) {
        userRepository.insert(user);
    }*/


}
