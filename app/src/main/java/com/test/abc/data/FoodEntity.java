package com.test.abc.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Food")
public class FoodEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Long id;

    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo(name = "brand")
    private String brand;

    @ColumnInfo(name = "fat")
    private Double fat;

    @ColumnInfo(name = "saturated_fat")
    private Double saturatedFat;

    @ColumnInfo(name = "unsaturated_fat")
    private Double unsaturatedFat;

    @ColumnInfo(name = "calories")
    private Integer calories;

    @ColumnInfo(name = "fiber")
    private Double fiber;

    @ColumnInfo(name = "potassium")
    private Double potassium;

    @ColumnInfo(name = "sugar")
    private Double sugar;

    @ColumnInfo(name = "protein")
    private Double protein;

    @ColumnInfo(name = "cholesterol")
    private Double cholesterol;

    @ColumnInfo(name = "sodium")
    private Double sodium;

    @ColumnInfo(name = "carbohydrates")
    private Double carbohydrates;

    // Immutable
    public FoodEntity(@NonNull Long id, @NonNull String title, String category, String brand, Double fat,
                      Double saturatedFat, Double unsaturatedFat, Integer calories, Double fiber, Double potassium,
                      Double sugar, Double protein, Double cholesterol, Double sodium, Double carbohydrates) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.brand = brand;
        this.fat = fat;
        this.saturatedFat = saturatedFat;
        this.unsaturatedFat = unsaturatedFat;
        this.calories = calories;
        this.fiber = fiber;
        this.potassium = potassium;
        this.sugar = sugar;
        this.protein = protein;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.carbohydrates = carbohydrates;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public Double getFat() {
        return fat;
    }

    public Double getSaturatedFat() {
        return saturatedFat;
    }

    public Double getUnsaturatedFat() {
        return unsaturatedFat;
    }

    public Integer getCalories() {
        return calories;
    }

    public Double getFiber() {
        return fiber;
    }

    public Double getPotassium() {
        return potassium;
    }

    public Double getSugar() {
        return sugar;
    }

    public Double getProtein() {
        return protein;
    }

    public Double getCholesterol() {
        return cholesterol;
    }

    public Double getSodium() {
        return sodium;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public static class Builder {

        private Long id;
        private String title;

        private String category;
        private String brand;

        private Double fat;
        private Double saturatedFat;
        private Double unsaturatedFat;
        private Integer calories;
        private Double fiber;
        private Double potassium;
        private Double sugar;
        private Double protein;
        private Double cholesterol;
        private Double sodium;
        private Double carbohydrates;


        public Builder(Long id, String title) {
            this.id = id;
            this.title = title;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setFat(Double fat) {
            this.fat = fat;
            return this;
        }

        public Builder setSaturatedFat(Double saturatedFat) {
            this.saturatedFat = saturatedFat;
            return this;
        }

        public Builder setUnsaturatedFat(Double unsaturatedFat) {
            this.unsaturatedFat = unsaturatedFat;
            return this;
        }

        public Builder setCalories(Integer calories) {
            this.calories = calories;
            return this;
        }

        public Builder setFiber(Double fiber) {
            this.fiber = fiber;
            return this;
        }

        public Builder setPotassium(Double potassium) {
            this.potassium = potassium;
            return this;
        }

        public Builder setSugar(Double sugar) {
            this.sugar = sugar;
            return this;
        }

        public Builder setProtein(Double protein) {
            this.protein = protein;
            return this;
        }

        public Builder setCholesterol(Double cholesterol) {
            this.cholesterol = cholesterol;
            return this;
        }

        public Builder setSodium(Double sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder setCarbohydrates(Double carbohydrates) {
            this.carbohydrates = carbohydrates;
            return this;
        }

        public FoodEntity build() {
            return new FoodEntity(id, title, category, brand, fat, saturatedFat, unsaturatedFat, calories, fiber,
                    potassium, sugar, protein, cholesterol, sodium, carbohydrates);
        }
    }
}
