package com.test.abc.data.di;

import com.test.abc.data.local.ABCDatabase;
import com.test.abc.data.local.FoodDAO;
import com.test.abc.data.remote.FoodAPI;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class FoodRepositoryModule {

    @Provides
    static FoodAPI providesFoodAPI(Retrofit retrofit) {
        return retrofit.create(FoodAPI.class);
    }

    @Provides
    static FoodDAO providesFoodDAO(ABCDatabase database) {
        return database.foodDao();
    }
}
