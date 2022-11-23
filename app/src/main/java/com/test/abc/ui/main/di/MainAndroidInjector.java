package com.test.abc.ui.main.di;

import com.test.abc.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainAndroidInjector {

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity contributeWithMainActivity();
}
