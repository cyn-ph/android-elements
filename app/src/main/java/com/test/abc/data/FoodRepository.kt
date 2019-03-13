package com.test.abc.data

import com.test.abc.beans.FoodResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FoodRepository {

    private lateinit var foodAPI: FoodAPI

    fun searchFood(query: String): Observable<FoodResponse> {

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.lifesum.com/")
            .build()

        foodAPI = retrofit.create(FoodAPI::class.java)

        return foodAPI.searchFood("es", "mx", query)

    }
}