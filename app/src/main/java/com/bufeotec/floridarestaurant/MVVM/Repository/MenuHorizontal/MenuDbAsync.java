package com.bufeotec.floridarestaurant.MVVM.Repository.MenuHorizontal;

import android.os.AsyncTask;



public class MenuDbAsync extends AsyncTask<Void, Void, Void> {

    private final MenuDao mDao;

    MenuDbAsync(MenuRoomDataBase db) {
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
