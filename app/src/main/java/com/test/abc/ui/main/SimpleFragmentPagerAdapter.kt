package com.test.abc.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.test.abc.ui.offline.OfflineFragment
import com.test.abc.ui.search.SearchFragment
import javax.inject.Inject

class SimpleFragmentPagerAdapter
@Inject constructor(
    fragmentManager: FragmentManager,
    val searchFragment: SearchFragment,
    val offlineFragment: OfflineFragment
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return searchFragment
            1 -> return offlineFragment
            else -> throw IllegalStateException("This is not possible")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Search"
            1 -> return "Offline"
            else -> return ""
        }
    }

    override fun getCount() = 2
}