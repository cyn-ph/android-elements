package com.test.abc.ui.main

import com.test.abc.ui.offline.OfflineFragment
import com.test.abc.ui.search.SearchFragment

class SimpleFragmentPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return SearchFragment()
            1 -> return OfflineFragment()
            else -> throw RuntimeException("This is not possible")
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