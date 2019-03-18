package com.test.abc.ui.main

import android.view.View
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.test.abc.data.FoodRepository
import com.test.abc.data.remote.Food
import com.test.abc.data.remote.FoodResponse
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class MainViewModelKTest {

    @Mock
    private lateinit var foodRepository: FoodRepository
    private lateinit var sut: MainViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        MockitoAnnotations.initMocks(this);
        sut = MainViewModel(foodRepository)
    }

    @Test
    fun searchFood_subscribe() {
        // Arrange
        val query = "Tacos"

        val searchFoodObservable = PublishSubject.create<FoodResponse>()
        `when`(foodRepository.searchFood(query)).thenReturn(searchFoodObservable)

        // Act
        sut.searchFood(query)
        val testObserver = searchFoodObservable.test()

        // Assert
        assertThat(sut.loading.value, `is`(View.VISIBLE))
        testObserver.assertSubscribed()
        testObserver.assertNoValues()
    }

    @Test
    fun searchFood_onNext() {
        // Arrange
        val query = "Tacos"
        val foodResponse = mock(FoodResponse::class.java)
        val foodList = ArrayList<Food>()

        `when`(foodResponse.foodList).thenReturn(foodList)
        val searchFoodObservable = PublishSubject.create<FoodResponse>()
        `when`(foodRepository.searchFood(query)).thenReturn(searchFoodObservable)

        // Act
        sut.searchFood(query)
        val testObserver = searchFoodObservable.test()
        searchFoodObservable.onNext(foodResponse)

        // Assert
        testObserver.assertValue(foodResponse)
        assertEquals(sut.searchResult.value, foodList)
        assertThat(sut.loading.value, `is`(View.INVISIBLE))
    }

    @Test
    fun searchFood_onError() {
        // Arrange
        val query = "Tacos"
        val error = java.lang.Exception()

        val searchFoodObservable = PublishSubject.create<FoodResponse>()
        `when`(foodRepository.searchFood(query)).thenReturn(searchFoodObservable)

        // Act
        sut.searchFood(query)
        val testObserver = searchFoodObservable.test()
        searchFoodObservable.onError(error)

        // Assert
        testObserver.assertError(error)
        assertThat(sut.loading.value, `is`(View.INVISIBLE))
    }

    @After
    fun tearDown() {
        RxAndroidPlugins.reset()
    }
}