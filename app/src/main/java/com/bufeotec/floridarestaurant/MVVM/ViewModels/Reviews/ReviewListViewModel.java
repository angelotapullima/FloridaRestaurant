package com.bufeotec.floridarestaurant.MVVM.ViewModels.Reviews;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;


import com.bufeotec.floridarestaurant.MVVM.Models.Reviews;
import com.bufeotec.floridarestaurant.MVVM.Repository.Reviews.ReviewsRoomDBRepository;
import com.bufeotec.floridarestaurant.MVVM.Repository.Reviews.ReviewsWebServiceRepository;

import java.util.List;

public class ReviewListViewModel extends AndroidViewModel {

    private ReviewsRoomDBRepository reviewsRoomDBRepository;
    private LiveData<List<Reviews>> mAllReviews;
    ReviewsWebServiceRepository reviewsWebServiceRepository;
    private final LiveData<List<Reviews>> retroObservable;
    public ReviewListViewModel(Application application){
        super(application);
        reviewsRoomDBRepository = new ReviewsRoomDBRepository(application);
        reviewsWebServiceRepository = new ReviewsWebServiceRepository(application);
        retroObservable = reviewsWebServiceRepository.providesWebService();
        //menuRoomDBRepository.insertPosts(retroObservable.getValue());
        mAllReviews = reviewsRoomDBRepository.getAllMenues();
    }

    public LiveData<List<Reviews>> getmAllReviews() {
        return mAllReviews;
    }

   /* public LiveData<List<ResultModel>> getProjectRetroListObservable() {
        return retroObservable;
    }*/

/*    public void insert(User user) {
        userRepository.insert(user);
    }*/


}
