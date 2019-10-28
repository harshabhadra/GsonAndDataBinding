package com.technoidtintin.gsonpractice1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.technoidtintin.gsonpractice1.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    CategoryAdapter categoryAdapter;
    CategoryViewModel categoryViewModel;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);

        mainBinding.categoryRecycler.setHasFixedSize(true);
        mainBinding.categoryRecycler.setLayoutManager(new GridLayoutManager(this, 3));
        categoryAdapter = new CategoryAdapter(this);
        mainBinding.categoryRecycler.setAdapter(categoryAdapter);

        categoryViewModel.getCategories().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object object) {
                mainBinding.loadingIndicator.setVisibility(View.GONE);
                if (object != null) {
                    List<Category> categories = object.getCategories();
                    categoryAdapter.setCategoryList(categories);
                }
            }
        });

        categoryViewModel.getRandomMeals().observe(this, new Observer<Random>() {
            @Override
            public void onChanged(Random random) {
                if (random != null) {

                    Log.e(TAG, "Random is not null");
                    List<Meal> mealList = random.getMeals();
                    for (int i = 0; i < mealList.size(); i++) {
                        Meal meal = new Meal(mealList.get(i).getStrMeal(), mealList.get(i).getStrMealThumb());
                        mainBinding.setMeal(meal);
                    }
                } else {
                    Log.e(TAG, "Random meal is null");
                }
            }
        });
    }
}
