package com.bufeotec.floridarestaurant.MVVM.Repository.Reviews;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;


import com.bufeotec.floridarestaurant.MVVM.Models.Reviews;

import java.util.List;

public class ReviewsRoomDBRepository {
    private ReviewsDao reviewsDao;
    LiveData<List<Reviews>> mAllReviews;

    public ReviewsRoomDBRepository(Application application){
         ReviewsRoomDataBase db = ReviewsRoomDataBase.getDatabase(application);
        reviewsDao = db.postInfoDao();
        mAllReviews = reviewsDao.getAllReviews();
     }

    public LiveData<List<Reviews>> getAllMenues() {
        return mAllReviews;
    }
    public void insertReviews(List<Reviews> menuModel) {
        new insertAsyncTask(reviewsDao).execute(menuModel);
    }

    private static class insertAsyncTask extends AsyncTask<List<Reviews>, Void, Void> {

        private ReviewsDao mAsyncTaskDao;

        insertAsyncTask(ReviewsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<Reviews>... params) {
            mAsyncTaskDao.insertReview(params[0]);
            return null;
        }
    }
}
