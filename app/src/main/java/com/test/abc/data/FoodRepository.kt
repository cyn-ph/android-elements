package com.test.abc.data

import android.content.Context
import com.test.abc.beans.Food
import com.test.abc.beans.FoodDAO
import com.test.abc.beans.FoodResponse
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class FoodRepository(context: Context) {

    private var foodAPI: FoodAPI
    private var foodDAO: FoodDAO

    init {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.lifesum.com/")
            .build()
        foodAPI = retrofit.create(FoodAPI::class.java)

        val db = ABCDatabase.getInstance(context)
        foodDAO = db.userDao()
    }

    fun searchFood(query: String): Observable<FoodResponse> {
        return foodAPI.searchFood("es", "mx", query)
    }

    fun saveFood(food: Food): Completable {
//        Observable.just(food)
//            .map { food -> parse(food) }
//            .mergeWith(foodDAO.insertFood(parse(food)))
        return foodDAO.insertFood(parse(food))
    }

    fun getAllSavedFood(): Single<List<FoodEntity>> {
        return foodDAO.all
    }

    fun parse(food: Food): FoodEntity {
        val foodEntityBuilder = FoodEntity.Builder(food.id, food.title)

        foodEntityBuilder.setCategory(food.category)
        foodEntityBuilder.setBrand(food.brand)
        foodEntityBuilder.setFat(food.fat)
        foodEntityBuilder.setSaturatedFat(food.saturatedFat)
        foodEntityBuilder.setUnsaturatedFat(food.unsaturatedFat)
        foodEntityBuilder.setCalories(food.calories)
        foodEntityBuilder.setFiber(food.fiber)
        foodEntityBuilder.setPotassium(food.potassium)
        foodEntityBuilder.setSugar(food.sugar)
        foodEntityBuilder.setProtein(food.protein)
        foodEntityBuilder.setCholesterol(food.cholesterol)
        foodEntityBuilder.setSodium(food.sodium)
        foodEntityBuilder.setCarbohydrates(food.carbohydrates)


        return foodEntityBuilder.build()
    }
}