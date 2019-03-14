package com.test.abc.ui.main;

import android.view.View;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import com.test.abc.data.FoodRepository;
import com.test.abc.data.remote.FoodResponse;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.Callable;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class MainViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private FoodRepository foodRepository;

    @Before
    public void setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
                return Schedulers.trampoline();
            }
        });
        foodRepository = mock(FoodRepository.class);
    }

    @Test
    public void searchFood_subscribe() {
        // Arrange
        MainViewModel sut = new MainViewModel(foodRepository);
        String query = "Tacos";
        FoodResponse foodResponse = new FoodResponse();

        PublishSubject<FoodResponse> foodResponseSubject = PublishSubject.create();
        Observable<FoodResponse> foodResponseObservable = Observable.just(foodResponse);

        when(foodRepository.searchFood(query)).thenReturn(foodResponseObservable);

        // Act
        sut.searchFood(query);

        // Assert
        assertThat(sut.getLoading().getValue(), is(View.VISIBLE));
        verify(foodRepository).searchFood(query);
        foodResponseObservable.test().assertSubscribed();
//        assertThat(foodResponseSubject.test().hasSubscription(), is(true));
    }

    @After
    public void tearDownClass() {
        RxAndroidPlugins.reset();
    }
}
