package com.bufeotec.floridarestaurant.MVVM.Repository.platos;

import android.os.AsyncTask;

public class ListPlatosDbAsync extends AsyncTask<Void, Void, Void> {

    private final ListPlatosDao mDao;

    ListPlatosDbAsync(ListPlatosRoomDataBase db) {
        mDao = db.postInfoDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        //mDao.deleteAll();
       /* User user = new User("Chandra","SW");
        mDao.insert(user);
        user = new User("Mohan","student");
        mDao.insert(user);*/
        return null;
    }
}
