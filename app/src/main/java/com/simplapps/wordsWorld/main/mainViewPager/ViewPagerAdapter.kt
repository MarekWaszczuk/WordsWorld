package com.simplapps.wordsWorld.main.mainViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.simplapps.wordsWorld.main.mainViewPager.Favourite.FavouriteFragment
import com.simplapps.wordsWorld.main.mainViewPager.Home.HomeFragment
import com.simplapps.wordsWorld.main.mainViewPager.Profile.ProfileFragment
import com.simplapps.wordsWorld.main.mainViewPager.Search.SearchFragment
import com.simplapps.wordsWorld.main.mainViewPager.Settings.MySettingsFragment

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