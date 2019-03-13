package com.test.abc.di;

import android.content.Context;
import com.test.abc.ABCApplication;
import com.test.abc.data.di.FoodRepositoryModule;
import com.test.abc.data.local.ABCDatabase;
import com.test.abc.ui.main.MainActivity;
import com.test.abc.ui.main.di.MainModule;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {AndroidSupportInjectionModule.class,
        FoodRepositoryModule.class})
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
    static ABCDatabase providesAbcDatabase(Context context) {
        return ABCDatabase.getInstance(context);
    }

    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity contributeWithMainActivity();

}
