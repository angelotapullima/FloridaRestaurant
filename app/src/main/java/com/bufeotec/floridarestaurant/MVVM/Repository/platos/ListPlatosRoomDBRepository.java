package com.bufeotec.floridarestaurant.MVVM.Repository.platos;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.bufeotec.floridarestaurant.MVVM.Models.ListaPlatos;

import java.util.List;

public class ListPlatosRoomDBRepository {
    private ListPlatosDao listPlatosDao;
    LiveData<List<ListaPlatos>> mAllPosts;

    public ListPlatosRoomDBRepository(Application application){
         ListPlatosRoomDataBase db = ListPlatosRoomDataBase.getDatabase(application);
        listPlatosDao = db.postInfoDao();
        mAllPosts = listPlatosDao.getAllPosts();
     }

    public LiveData<List<ListaPlatos>> getAllPosts() {
        return mAllPosts;
    }
    public void insertPosts (List<ListaPlatos> listaPlatos) {
        new insertAsyncTask(listPlatosDao).execute(listaPlatos);
    }

    private static class insertAsyncTask extends AsyncTask<List<ListaPlatos>, Void, Void> {

        private ListPlatosDao mAsyncTaskDao;

        insertAsyncTask(ListPlatosDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<ListaPlatos>... params) {
            mAsyncTaskDao.insertPosts(params[0]);
            return null;
        }
    }
}
