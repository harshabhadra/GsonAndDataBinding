package com.technoidtintin.gsonpractice1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    private Repository repository;

    public CategoryViewModel() {

        repository = Repository.getInstance();
    }

    public LiveData<Object> getCategories(){
        return repository.getCategories();
    }

    LiveData<Random>getRandomMeals(){
        return repository.getRandomMeals();
    }
}
