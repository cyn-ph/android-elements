package com.test.abc.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.abc.data.FoodRepository
import javax.inject.Inject

/**
 * Factory for ViewModels
 */
class MainViewModelFactory
@Inject constructor(private val foodRepository: FoodRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(foodRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
