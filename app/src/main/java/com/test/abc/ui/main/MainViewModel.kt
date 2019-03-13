package com.test.abc.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.util.Log
import android.view.View
import com.test.abc.beans.Food
import com.test.abc.data.FoodEntity
import com.test.abc.data.FoodRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(context: Context) : ViewModel() {

    val searchResult = MutableLiveData<List<Food>>()
    val offlineFood = MutableLiveData<List<FoodEntity>>()
    val loading = MutableLiveData<Int>()

    val foodRespository = FoodRepository(context)

    fun searchFood(query: String) {
        Log.d("SEARCH", query)
        loading.value = View.VISIBLE

        foodRespository.searchFood(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    Log.d("SEARCH", "on success with ${result.foodList.size}")
                    searchResult.value = result.foodList
                    loading.value = View.INVISIBLE

                },
                { error ->
                    Log.e("SEARCH", error.message, error)
                    loading.value = View.INVISIBLE
                }
            )
    }

    fun saveFood(food: Food) {
        foodRespository.saveFood(food)
            .subscribeOn(Schedulers.io())
            .subscribe()
        Log.d("OFFLINE", "add food ${food.title}, total ${offlineFood.value!!.size}")
    }

    fun getAllSavedFood() {
        foodRespository.getAllSavedFood()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ savedFood ->
                Log.d("OFFLINE", "on success with ${savedFood.size}")
                offlineFood.value = savedFood
            }, { error ->
                Log.e("OFFLINE", error.message, error)
            })
    }

}