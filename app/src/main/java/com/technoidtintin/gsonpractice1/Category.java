package com.technoidtintin.gsonpractice1;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class Category {

    @SerializedName("idCategory")
    @Expose
    private String idCategory;
    @SerializedName("strCategory")
    @Expose
    private String strCategory;
    @SerializedName("strCategoryThumb")
    @Expose
    private String strCategoryThumb;
    @SerializedName("strCategoryDescription")
    @Expose
    private String strCategoryDescription;

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;
    }

    @BindingAdapter({"strCategoryThumb"})
    public static void loadImage(ImageView imageView,String imageUrl){

        Picasso.get().load(imageUrl).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
