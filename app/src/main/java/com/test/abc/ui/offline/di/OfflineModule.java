package com.test.abc.ui.offline.di;

import com.test.abc.ui.offline.OfflineFragment;
import dagger.Module;
import dagger.Provides;

@Module
public class OfflineModule {

    @Provides
    public static OfflineFragment providesOfflineFragment() {
        return new OfflineFragment();
    }

}
