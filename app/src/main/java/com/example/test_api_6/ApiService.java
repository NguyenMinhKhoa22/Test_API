package com.example.test_api_6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    // https://api.themoviedb.org/3/movie/popular?api_key=ab0667fb0b0c1e076bd874cf0a174098&language=en-US&page=1

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("3/movie/popular")
    Call<Data> convertData(@Query("api_key") String api_key,
                           @Query("language") String language,
                           @Query("page") int page);

}
