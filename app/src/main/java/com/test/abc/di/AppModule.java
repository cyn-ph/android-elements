package com.test.abc.di;

import android.content.Context;
import android.content.res.Resources;
import androidx.room.Room;
import com.test.abc.ABCApplication;
import com.test.abc.data.di.FoodRepositoryModule;
import com.test.abc.data.local.ABCDatabase;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

@Module(includes = {FoodRepositoryModule.class})
public abstract class AppModule {

    @Provides
    static Context providesApplicationContext(ABCApplication abcApplication) {
        return abcApplication;
    }

    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.lifesum.com/")
                .build();
    }


    @Provides
    @Singleton
    static ABCDatabase providesAbcDatabase(Context context) {
        return Room.databaseBuilder(context,
                ABCDatabase.class, "ABC.db")
                .build();
    }

    @Provides
    static Resources providesResources(ABCApplication abcApplication) {
        return abcApplication.getResources();
    }

}
