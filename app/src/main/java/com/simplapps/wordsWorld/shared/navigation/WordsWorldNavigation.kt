package com.simplapps.wordsWorld.shared.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.simplapps.wordsWorld.main.mainViewPager.ViewPagerFragment

class WordsWorldNavigation {

    private var activity: AppCompatActivity? = null
    lateinit var fragmentManager: FragmentManager

    fun init(activity: AppCompatActivity,
             fragmentManager: FragmentManager) {

        this.fragmentManager = fragmentManager
        this.activity = activity

        fragmentManager.beginTransaction().add(ViewPagerFragment(), "VP").commit()
    }

    fun changeFragment(fragment: Fragment) {
        val ft = fragmentManager.beginTransaction()
        ft.remove(fragmentManager.findFragmentByTag("VP")!!)
        ft.add(fragment, "its just a basic navigation without states")
        ft.commitNow()

        /*Turns out  add only adds a fragment, but to display a new fragment, I need to
        * hide/remove the old one. It can be done by ft.hide old one and ft.show new one or
        * ft.remove and then ft.add
        *
        * OKAY I DONT FUCKING KNOW NO COMMITS ON FT WORK WTF*/
    }
}