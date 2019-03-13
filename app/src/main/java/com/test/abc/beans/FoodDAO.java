package com.test.abc.beans;

public class FoodDAO {

    private Long id;
    private String category;
    private String title;

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

    public FoodDAO(String category, String title) {
        this.category = category;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
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
}
