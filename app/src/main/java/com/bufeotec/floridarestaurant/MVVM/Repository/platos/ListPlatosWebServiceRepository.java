package com.bufeotec.floridarestaurant.MVVM.Repository.platos;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;


import com.bufeotec.floridarestaurant.MVVM.APIUrl;
import com.bufeotec.floridarestaurant.MVVM.Models.ListaPlatos;

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

public class ListPlatosWebServiceRepository {

    Application application;
    public ListPlatosWebServiceRepository(Application application){
        this.application = application;
    }
    private static OkHttpClient providesOkHttpClientBuilder(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return httpClient.readTimeout(1200, TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS).build();

    }


    List<ListaPlatos> webserviceResponseList = new ArrayList<>();

 public LiveData<List<ListaPlatos>> providesWebService() {

     final MutableLiveData<List<ListaPlatos>> data = new MutableLiveData<>();

     String response = "";
     try {
         Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl(APIUrl.BASE_URL)
                 .addConverterFactory(ScalarsConverterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())
                 .client(providesOkHttpClientBuilder())
                 .build();

         //Defining retrofit api service
         APIService service = retrofit.create(APIService.class);
        //  response = service.makeRequest().execute().body();
         service.makeRequest().enqueue(new Callback<String>() {
             @Override
             public void onResponse(Call<String> call, Response<String> response) {
                 Log.d("Repository","Response::::"+response.body());
                 webserviceResponseList = parseJson(response.body());
                 ListPlatosRoomDBRepository listPlatosRoomDBRepository = new ListPlatosRoomDBRepository(application);
                 listPlatosRoomDBRepository.insertPosts(webserviceResponseList);
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

     //  return retrofit.create(ListaPlatos.class);
     return  data;

    }


    private List<ListaPlatos> parseJson(String response) {

        List<ListaPlatos> apiResults = new ArrayList<>();

        JSONObject jsonObject;

        JSONArray jsonArray;

        try {
            jsonObject = new JSONObject(response);
            JSONArray resultJSON = jsonObject.getJSONArray("results");

            int count = resultJSON.length();


            for (int i = 0; i < count; i++) {
                JSONObject jsonNode = resultJSON.getJSONObject(i);
                ListaPlatos listaPlatos = new ListaPlatos();

                //mMovieModel.setId(object.getString("id"));


                listaPlatos.setPlato_id(jsonNode.getString("plato_id"));
                listaPlatos.setPlato_nombre(jsonNode.getString("plato_nombre"));
                listaPlatos.setPlato_precio(jsonNode.getString("plato_precio"));
                listaPlatos.setPlato_disponibilidad(jsonNode.getString("plato_disponibilidad"));
                listaPlatos.setPlato_descripcion(jsonNode.getString("plato_descripcion"));
                listaPlatos.setPlato_foto(jsonNode.getString("plato_foto"));

                apiResults.add(listaPlatos);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i(getClass().getSimpleName(), String.valueOf(apiResults.size()));
        return apiResults;

    }
}
