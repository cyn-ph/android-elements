package com.test.abc.ui.tabs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.abc.data.FoodRepository
import javax.inject.Inject

/**
 * Factory for ViewModels
 */
class TabsViewModelFactory
@Inject constructor(private val foodRepository: FoodRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TabsViewModel::class.java)) {
            return TabsViewModel(foodRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
