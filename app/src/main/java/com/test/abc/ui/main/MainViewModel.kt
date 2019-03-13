package com.test.abc.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import android.view.View
import com.test.abc.beans.Food
import com.test.abc.data.FoodRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    val searchResult = MutableLiveData<List<Food>>()
    val loading = MutableLiveData<Int>()

    val foodRespository = FoodRepository()

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
}