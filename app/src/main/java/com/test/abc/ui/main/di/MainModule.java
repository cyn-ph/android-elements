package com.test.abc.ui.main.di;

import androidx.fragment.app.FragmentManager;
import com.test.abc.ui.main.MainActivity;
import com.test.abc.ui.offline.OfflineFragment;
import com.test.abc.ui.search.SearchFragment;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainModule {

    @Provides
    static FragmentManager providesFragmentManager(MainActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @Provides
    static SearchFragment providesSearchFragment() {
        return new SearchFragment();
    }

    @Provides
    static OfflineFragment providesOfflineFragment() {
        return new OfflineFragment();
    }

}
