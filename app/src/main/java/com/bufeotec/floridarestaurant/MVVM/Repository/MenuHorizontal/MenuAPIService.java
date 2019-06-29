package com.bufeotec.floridarestaurant.MVVM.Repository.MenuHorizontal;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MenuAPIService {
    @GET("angelo/menu.php")
    Call<String> makeRequest();
}
