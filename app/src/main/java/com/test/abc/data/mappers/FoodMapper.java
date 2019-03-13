package com.test.abc.data.mappers;

import com.test.abc.data.local.FoodEntity;
import com.test.abc.data.remote.Food;

public class FoodMapper {

    public FoodEntity toFoodEntity(Food food) {
        FoodEntity.Builder foodEntityBuilder = new FoodEntity.Builder(food.getId(), food.getTitle());

        foodEntityBuilder.setCategory(food.getCategory());
        foodEntityBuilder.setBrand(food.getBrand());
        foodEntityBuilder.setFat(food.getFat());
        foodEntityBuilder.setSaturatedFat(food.getSaturatedFat());
        foodEntityBuilder.setUnsaturatedFat(food.getUnsaturatedFat());
        foodEntityBuilder.setCalories(food.getCalories());
        foodEntityBuilder.setFiber(food.getFiber());
        foodEntityBuilder.setPotassium(food.getPotassium());
        foodEntityBuilder.setSugar(food.getSugar());
        foodEntityBuilder.setProtein(food.getProtein());
        foodEntityBuilder.setCholesterol(food.getCholesterol());
        foodEntityBuilder.setSodium(food.getSodium());
        foodEntityBuilder.setCarbohydrates(food.getCarbohydrates());

        return foodEntityBuilder.build();
    }
}
