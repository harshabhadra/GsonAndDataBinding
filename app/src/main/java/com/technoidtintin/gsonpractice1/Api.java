package com.technoidtintin.gsonpractice1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL ="https://www.themealdb.com/";

    //Get food categories
    @GET("/api/json/v1/1/categories.php")
    Call<Object>getCategoryList();

    //Get a random meal
    @GET("/api/json/v1/1/random.php")
    Call<Random>getRandomMill();
}
