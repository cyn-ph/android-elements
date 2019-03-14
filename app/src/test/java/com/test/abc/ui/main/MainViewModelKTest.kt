package com.test.abc.ui.main

import android.view.View
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.test.abc.data.FoodRepository
import com.test.abc.data.remote.FoodResponse
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MainViewModelKTest {

    lateinit var foodRepository: FoodRepository

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        foodRepository = mock(FoodRepository::class.java)
    }

    @Test
    fun searchFood_subscribe() {
        // Arrange
        val sut = MainViewModel(foodRepository)
        val query = "Tacos"

        val subject = PublishSubject.create<FoodResponse>()
//        doReturn(subject).`when`(foodRepository).searchFood(query)
        `when`(foodRepository.searchFood(query)).thenReturn(subject)

        // Act
        sut.searchFood(query)

        // Assert
        assertThat(sut.loading.value, `is`(View.VISIBLE))
        val testObserver = subject.test()
        testObserver.assertEmpty()
        testObserver.onNext(FoodResponse())
        testObserver.assertEmpty()
//        testObserver.assertSubscribed()
//        assertThat(subject.test().hasSubscription(), `is`(true))
    }

    @Test
    fun saveFood() {
    }

    @Test
    fun getAllSavedFood() {
    }

    @Test
    fun onCleared() {
    }

    @After
    fun tearDown() {
        RxAndroidPlugins.reset()
    }
}