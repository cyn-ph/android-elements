package com.test.abc.data

import android.content.Context
import com.test.abc.data.local.ABCDatabase
import com.test.abc.data.local.FoodDAO
import com.test.abc.data.local.FoodEntity
import com.test.abc.data.mappers.FoodMapper
import com.test.abc.data.remote.Food
import com.test.abc.data.remote.FoodAPI
import com.test.abc.data.remote.FoodResponse
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class FoodRepository(context: Context) {

    private var foodAPI: FoodAPI
    private var foodDAO: FoodDAO
    private val foodMapper = FoodMapper()

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
        return foodDAO.insertFood(foodMapper.toFoodEntity(food))
    }

    fun getAllSavedFood(): Single<List<FoodEntity>> {
        return foodDAO.all
    }

}