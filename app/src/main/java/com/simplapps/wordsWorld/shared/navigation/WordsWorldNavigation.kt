package com.simplapps.wordsWorld.shared.navigation


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.simplapps.wordsWorld.R
import com.simplapps.wordsWorld.main.learnWords.LearnWordsFragment
import com.simplapps.wordsWorld.main.mainViewPager.ViewPagerFragment

class WordsWorldNavigation {

    private var activity: AppCompatActivity? = null
    lateinit var fragmentManager: FragmentManager
    private var fullScreenContainer = 0
    private var container = 0
    private var myfrag = ViewPagerFragment()

    fun init(activity: AppCompatActivity,
             fragmentManager: FragmentManager,
             fullScreenContainer: Int,
             container: Int) {

        this.fragmentManager = fragmentManager
        this.activity = activity
        this.fullScreenContainer = fullScreenContainer
        this.container = container


        fragmentManager.beginTransaction().add(container, myfrag, "VP").commit()
    }

    fun changeFragment(fragment: Fragment) {
        val ft = fragmentManager.beginTransaction()
        ft.remove(fragmentManager.findFragmentByTag("VP")!!)
        ft.commitNow()

        val ft2 = fragmentManager.beginTransaction()
        ft2.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
        ft2.add(fullScreenContainer, LearnWordsFragment())
        ft2.commitNow()
        fragmentManager.popBackStackImmediate()

        /*Turns out  add only adds a fragment, but to display a new fragment, I need to
        * hide/remove the old one. It can be done by ft.hide old one and ft.show new one or
        * ft.remove and then ft.add
        *
        * OKAY I DONT FUCKING KNOW NO COMMITS ON FT WORK WTF*/
    }
}