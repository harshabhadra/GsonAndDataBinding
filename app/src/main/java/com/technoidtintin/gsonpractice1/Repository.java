package com.technoidtintin.gsonpractice1;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private static final String TAG = Repository.class.getSimpleName();

    public static Repository getInstance(){
        return new Repository();
    }

    private MutableLiveData<Object>listMutableLiveData = new MutableLiveData<>();

    private MutableLiveData<Random>randomMutableLiveData = new MutableLiveData<>();

    LiveData<Random>getRandomMeals(){
        getRandom();
        return randomMutableLiveData;
    }

    public LiveData<Object>getCategories(){

        getFoodCategories();
        return listMutableLiveData;
    }

    private void getFoodCategories() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<Object>call = api.getCategoryList();
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                if (response.isSuccessful() && response.body() != null){

                    Log.e(TAG,"Response is sucessful: " + response.body().toString());
                    listMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

                Log.e(TAG,"Response failure: " + t.getMessage());
            }
        });
    }

    private void getRandom() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<Random>call = api.getRandomMill();
        call.enqueue(new Callback<Random>() {
            @Override
            public void onResponse(Call<Random> call, Response<Random> response) {
                if (response.isSuccessful() && response.body() != null){

                    Log.e(TAG,"Random response is successful");
                    randomMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Random> call, Throwable t) {

                Log.e(TAG,"Random response failure");
            }
        });
    }

}
