package com.bufeotec.floridarestaurant.MVVM.Repository.Reviews;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ReviewsAPIService {
    @GET("angelo/reviews.php")
    Call<String> makeRequest();
}
