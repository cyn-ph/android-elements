package com.test.abc.beans;

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

    public String getTitle() {
        return title;
    }
}
