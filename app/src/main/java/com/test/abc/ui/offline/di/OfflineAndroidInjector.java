package com.test.abc.ui.offline.di;

import com.test.abc.ui.offline.OfflineFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = OfflineModule.class)
public abstract class OfflineAndroidInjector {

    @ContributesAndroidInjector
    abstract OfflineFragment contributeWithOfflineFragment();

}
