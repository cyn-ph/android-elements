package com.test.abc.ui.offline.di;

import com.test.abc.ui.offline.OfflineAdapter;
import dagger.Module;
import dagger.Provides;

@Module
public class OfflineModule {

    @Provides
    static OfflineAdapter providesOfflineAdapter() {
        return new OfflineAdapter();
    }

}
