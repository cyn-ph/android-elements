package com.test.abc.ui.main

import android.os.Bundle
import com.test.abc.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        viewPager.adapter = SimpleFragmentPagerAdapter(supportFragmentManager)

        val tabs = findViewById<TabLayout>(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }
}