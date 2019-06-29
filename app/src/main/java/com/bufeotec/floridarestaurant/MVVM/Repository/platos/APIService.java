package com.bufeotec.floridarestaurant.MVVM.Repository.platos;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("angelo/platos.php")
    Call<String> makeRequest();
}
