package com.bufeotec.floridarestaurant.MVVM.Repository.Reviews;

import android.os.AsyncTask;

public class ReviewsDbAsync extends AsyncTask<Void, Void, Void> {

    private final ReviewsDao reviewsDao;

    ReviewsDbAsync(ReviewsRoomDataBase db) {
        reviewsDao = db.postInfoDao();
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
