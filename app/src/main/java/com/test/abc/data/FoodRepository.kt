package com.test.abc.data

import com.test.abc.data.local.FoodDAO
import com.test.abc.data.local.FoodEntity
import com.test.abc.data.mappers.FoodMapper
import com.test.abc.data.remote.Food
import com.test.abc.data.remote.FoodAPI
import com.test.abc.data.remote.FoodResponse
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

open class FoodRepository
@Inject constructor(
    val foodAPI: FoodAPI,
    val foodDAO: FoodDAO,
    val foodMapper: FoodMapper
) {

    open fun searchFood(query: String): Observable<FoodResponse> {
        return foodAPI.searchFood("es", "mx", query)
    }

    open fun saveFood(food: Food): Completable {
        return Observable.just(food)
            .map { foodMapper.toFoodEntity(food) }
            .flatMapCompletable { foodEntity -> foodDAO.insertFood(foodEntity) }
    }

    open fun getAllSavedFood(): Single<List<FoodEntity>> {
        return foodDAO.all
    }

}