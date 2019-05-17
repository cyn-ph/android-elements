package com.test.abc.ui.tabs.di;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.test.abc.ui.offline.di.OfflineAndroidInjector;
import com.test.abc.ui.search.di.SearchAndroidInjector;
import com.test.abc.ui.tabs.TabsFragment;
import com.test.abc.ui.tabs.TabsViewModel;
import com.test.abc.ui.tabs.TabsViewModelFactory;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(includes = {SearchAndroidInjector.class, OfflineAndroidInjector.class})
public abstract class TabsModule {

    @Provides
    static FragmentManager providesFragmentManager(TabsFragment fragment) {
        return fragment.getChildFragmentManager();
    }

    @Provides
    static TabsViewModel providesMainViewModel(TabsFragment fragment,
                                               TabsViewModelFactory viewModelFactory) {
        return ViewModelProviders.of(fragment, viewModelFactory).get(TabsViewModel.class);
    }

    @Provides
    @Singleton
    static TabsFragment providesTabsFragment() {
        TabsFragment f = new TabsFragment();
        return f;
    }
}
