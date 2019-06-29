package com.bufeotec.floridarestaurant.MVVM.Repository.Reviews;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.bufeotec.floridarestaurant.MVVM.APIUrl;
import com.bufeotec.floridarestaurant.MVVM.Models.Reviews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ReviewsWebServiceRepository {

    Application application;
    public ReviewsWebServiceRepository(Application application){
        this.application = application;
    }
    private static OkHttpClient providesOkHttpClientBuilder(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return httpClient.readTimeout(1200, TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS).build();

    }


    List<Reviews> webserviceResponseList = new ArrayList<>();

 public LiveData<List<Reviews>> providesWebService() {

     final MutableLiveData<List<Reviews>> data = new MutableLiveData<>();

     String response = "";
     try {
         Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl(APIUrl.BASE_URL)
                 .addConverterFactory(ScalarsConverterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .client(providesOkHttpClientBuilder())
                 .build();

         //Defining retrofit api service
         ReviewsAPIService service = retrofit.create(ReviewsAPIService.class);
        //  response = service.makeRequest().execute().body();
         service.makeRequest().enqueue(new Callback<String>() {
             @Override
             public void onResponse(Call<String> call, Response<String> response) {
                 Log.d("Repository","Response::::"+response.body());
                 webserviceResponseList = parseJson(response.body());
                 ReviewsRoomDBRepository reviewsRoomDBRepository = new ReviewsRoomDBRepository(application);
                 reviewsRoomDBRepository.insertReviews(webserviceResponseList);
                 data.setValue(webserviceResponseList);

             }

             @Override
             public void onFailure(Call<String> call, Throwable t) {
                 Log.d("Repository","Failed:::");
             }
         });
     }catch (Exception e){
         e.printStackTrace();
     }

     //  return retrofit.create(ResultModel.class);
     return  data;

    }


    private List<Reviews> parseJson(String response) {

        List<Reviews> apiResults = new ArrayList<>();

        JSONObject jsonObject;

        JSONArray jsonArray;

        try {
            jsonObject = new JSONObject(response);
            JSONArray resultJSON = jsonObject.getJSONArray("results");

            int count = resultJSON.length();


            for (int i = 0; i < count; i++) {
                JSONObject jsonNode = resultJSON.getJSONObject(i);
                Reviews reviews = new Reviews();

                //mMovieModel.setId(object.getString("id"));
                reviews.setReview_foto(jsonNode.getString("foto"));
                reviews.setReview_nombre(jsonNode.getString("nombre"));
                reviews.setReview_id(jsonNode.getString("id"));
                reviews.setReview_descripcion(jsonNode.getString("descripcion"));

                apiResults.add(reviews);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i(getClass().getSimpleName(), String.valueOf(apiResults.size()));
        return apiResults;

    }
}
