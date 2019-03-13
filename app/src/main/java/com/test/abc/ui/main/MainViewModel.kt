package com.test.abc.ui.main

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.abc.beans.Food
import com.test.abc.data.FoodEntity
import com.test.abc.data.FoodRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    val searchResult = MutableLiveData<List<Food>>()
    val offlineFood = MutableLiveData<List<FoodEntity>>()
    val loading = MutableLiveData<Int>()
    private lateinit var foodRespository: FoodRepository

    fun init(context: Context) {
        foodRespository = FoodRepository(context)
    }

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