package com.bufeotec.floridarestaurant.MVVM.Repository.Reviews;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.bufeotec.floridarestaurant.MVVM.Models.Reviews;

import java.util.List;

@Dao
public interface ReviewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Reviews resultModel);

    @Query("SELECT * from lista_reviews")
    LiveData<List<Reviews>> getAllReviews();

    @Query("DELETE FROM lista_reviews")
    void deleteAll();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertReview(List<Reviews> resultModel);

}
