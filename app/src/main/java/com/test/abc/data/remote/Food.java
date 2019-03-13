package com.test.abc.data.remote;

import com.google.gson.annotations.SerializedName;

public class Food {
    @SerializedName("fat")
    private Double fat;
    @SerializedName("id")
    private Long id;
    @SerializedName("calories")
    private Integer calories;
    @SerializedName("fiber")
    private Double fiber;
    @SerializedName("category")
    private String category;
    @SerializedName("typeofmeasurement")
    private Integer typeOfMeasurement;
    @SerializedName("potassium")
    private Double potassium;
    @SerializedName("title")
    private String title;
    @SerializedName("gramsperserving")
    private Integer gramsPerServing;
    @SerializedName("headcategoryid")
    private Long headCategoryId;
    @SerializedName("serving_version")
    private Integer servingVersion;
    @SerializedName("pcstext")
    private String pcsText;
    @SerializedName("sugar")
    private Double sugar;
    @SerializedName("mlingram")
    private Double mlInGram;
    @SerializedName("protein")
    private Double protein;
    @SerializedName("verified")
    private Boolean verified;
    @SerializedName("brand")
    private String brand;
    @SerializedName("pcsingram")
    private Double pcsInGram;
    @SerializedName("defaultserving")
    private Integer defaultServing;
    @SerializedName("cholesterol")
    private Double cholesterol;
    @SerializedName("showonlysametype")
    private Integer showOnlySameType;
    @SerializedName("sodium")
    private Double sodium;
    @SerializedName("showmeasurement")
    private Integer showMeasurement;
    @SerializedName("unsaturatedfat")
    private Double unsaturatedFat;
    @SerializedName("measurementid")
    private Long measurementId;
    @SerializedName("categoryid")
    private Long categoryId;
    @SerializedName("servingcategory")
    private Integer servingCategory;
    @SerializedName("carbohydrates")
    private Double carbohydrates;
    @SerializedName("validnutritions")
    private String validNutrition;
    @SerializedName("saturatedfat")
    private Double saturatedFat;

    public Double getFat() {
        return fat;
    }

    public Long getId() {
        return id;
    }

    public Integer getCalories() {
        return calories;
    }

    public Double getFiber() {
        return fiber;
    }

    public String getCategory() {
        return category;
    }

    public Integer getTypeOfMeasurement() {
        return typeOfMeasurement;
    }

    public Double getPotassium() {
        return potassium;
    }

    public String getTitle() {
        return title;
    }

    public Integer getGramsPerServing() {
        return gramsPerServing;
    }

    public Long getHeadCategoryId() {
        return headCategoryId;
    }

    public Integer getServingVersion() {
        return servingVersion;
    }

    public String getPcsText() {
        return pcsText;
    }

    public Double getSugar() {
        return sugar;
    }

    public Double getMlInGram() {
        return mlInGram;
    }

    public Double getProtein() {
        return protein;
    }

    public Boolean getVerified() {
        return verified;
    }

    public String getBrand() {
        return brand;
    }

    public Double getPcsInGram() {
        return pcsInGram;
    }

    public Integer getDefaultServing() {
        return defaultServing;
    }

    public Double getCholesterol() {
        return cholesterol;
    }

    public Integer getShowOnlySameType() {
        return showOnlySameType;
    }

    public Double getSodium() {
        return sodium;
    }

    public Integer getShowMeasurement() {
        return showMeasurement;
    }

    public Double getUnsaturatedFat() {
        return unsaturatedFat;
    }

    public Long getMeasurementId() {
        return measurementId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Integer getServingCategory() {
        return servingCategory;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public String getValidNutrition() {
        return validNutrition;
    }

    public Double getSaturatedFat() {
        return saturatedFat;
    }
}
