package com.test.abc.ui.main

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.abc.data.FoodRepository
import com.test.abc.data.local.FoodEntity
import com.test.abc.data.remote.Food
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel
@Inject constructor(foodRepository: FoodRepository) : ViewModel() {

    private val foodRespository = foodRepository

    val searchResult = MutableLiveData<List<Food>>()
    val offlineFood = MutableLiveData<List<FoodEntity>>()
    val loading = MutableLiveData<Int>()

    fun searchFood(query: String) {
        loading.value = View.VISIBLE

        foodRespository.searchFood(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    searchResult.value = result.foodList
                    loading.value = View.INVISIBLE
                },
                { error ->
                    loading.value = View.INVISIBLE
                }
            )
    }

    fun saveFood(food: Food) {
        foodRespository.saveFood(food)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getAllSavedFood()
            }, {
                // TODO : Handle error
            })
    }

    fun getAllSavedFood() {
        loading.value = View.VISIBLE

        foodRespository.getAllSavedFood()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ savedFood ->
                offlineFood.value = savedFood
                loading.value = View.INVISIBLE
            }, { error ->
                loading.value = View.INVISIBLE
            })
    }

}