package com.technoidtintin.gsonpractice1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.technoidtintin.gsonpractice1.databinding.FoodItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private static final String TAG = CategoryAdapter.class.getSimpleName();
    private Context context;
    private List<Category> categoryList = new ArrayList<>();

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FoodItemBinding foodItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.food_item, parent, false);

        return new CategoryViewHolder(foodItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        if (categoryList != null) {
            Log.e(TAG, "Category list is full");
            Category category = categoryList.get(position);
            holder.foodItemBinding.setCategory(category);
        } else {
            Log.e(TAG, "Category list is empty");
        }
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        FoodItemBinding foodItemBinding;

        public CategoryViewHolder(FoodItemBinding foodItemBinding) {
            super(foodItemBinding.getRoot());

            this.foodItemBinding = foodItemBinding;

        }
    }
}
