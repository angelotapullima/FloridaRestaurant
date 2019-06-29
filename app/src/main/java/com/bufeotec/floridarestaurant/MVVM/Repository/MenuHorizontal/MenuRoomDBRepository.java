package com.bufeotec.floridarestaurant.MVVM.Repository.MenuHorizontal;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import com.bufeotec.floridarestaurant.MVVM.Models.Menu;
import com.bufeotec.floridarestaurant.MVVM.Repository.MenuHorizontal.MenuDao;

import java.util.List;

public class MenuRoomDBRepository {
    private MenuDao menuDao;
    LiveData<List<Menu>> mAllMenu;

    public MenuRoomDBRepository(Application application){
         MenuRoomDataBase db = MenuRoomDataBase.getDatabase(application);
        menuDao = db.postInfoDao();
        mAllMenu = menuDao.getAllMenus();
     }

    public LiveData<List<Menu>> getAllMenues() {
        return mAllMenu;
    }
    public void insertMenu(List<Menu> menuModel) {
        new insertAsyncTask(menuDao).execute(menuModel);
    }

    private static class insertAsyncTask extends AsyncTask<List<Menu>, Void, Void> {

        private MenuDao mAsyncTaskDao;

        insertAsyncTask(MenuDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<Menu>... params) {
            mAsyncTaskDao.insertMenu(params[0]);
            return null;
        }
    }
}
