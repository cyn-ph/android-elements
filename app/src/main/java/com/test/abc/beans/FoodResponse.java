package com.test.abc.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodResponse {
    @SerializedName("food")
    private List<Food> foodList;

    public List<Food> getFoodList() {
        return foodList;
    }
}
