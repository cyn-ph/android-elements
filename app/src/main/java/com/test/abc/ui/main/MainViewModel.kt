package com.test.abc.ui.main

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.abc.data.FoodRepository
import com.test.abc.data.local.FoodEntity
import com.test.abc.data.remote.Food
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel
@Inject constructor(foodRepository: FoodRepository) : ViewModel() {

    private val foodRespository = foodRepository

    val searchResult = MutableLiveData<List<Food>>()
    val offlineFood = MutableLiveData<List<FoodEntity>>()
    val loading = MutableLiveData<Int>()
    val disposables = mutableListOf<Disposable>()

    fun searchFood(query: String) {
        loading.value = View.VISIBLE

        val searchDisposable = foodRespository.searchFood(query)
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
        disposables.add(searchDisposable)
    }

    fun saveFood(food: Food) {
        val saveDisposable = foodRespository.saveFood(food)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getAllSavedFood()
            }, {
                // TODO : Handle error
            })
        disposables.add(saveDisposable)
    }

    fun getAllSavedFood() {
        loading.value = View.VISIBLE

        val getSavedFoodDisposable = foodRespository.getAllSavedFood()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ savedFood ->
                offlineFood.value = savedFood
                loading.value = View.INVISIBLE
            }, { error ->
                loading.value = View.INVISIBLE
            })

        disposables.add(getSavedFoodDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        diposeSubscriptions(disposables)
    }

    private fun diposeSubscriptions(disposables: MutableList<Disposable>) {
        for (d in disposables) {
            d.dispose()
        }
    }

}