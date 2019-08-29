package com.simplapps.wordsWorld.main.mainViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.simplapps.wordsWorld.main.mainViewPager.favourite.FavouriteFragment
import com.simplapps.wordsWorld.main.mainViewPager.home.HomeFragment
import com.simplapps.wordsWorld.main.mainViewPager.profile.ProfileFragment
import com.simplapps.wordsWorld.main.mainViewPager.search.SearchFragment
import com.simplapps.wordsWorld.main.mainViewPager.settings.MySettingsFragment

private const val NUM_PAGES = 5

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> ProfileFragment()
            2 -> FavouriteFragment()
            3 -> SearchFragment()
            else -> MySettingsFragment()
        }
    }

    override fun getCount(): Int {
        return NUM_PAGES
    }
}