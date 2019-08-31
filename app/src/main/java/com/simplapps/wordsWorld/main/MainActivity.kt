package com.simplapps.wordsWorld.main

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import android.content.res.Configuration
import android.graphics.PorterDuff
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import com.simplapps.wordsWorld.R
import com.simplapps.wordsWorld.main.mainViewPager.ViewPagerAdapter
import com.simplapps.wordsWorld.shared.navigation.WordsWorldNavigation
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.drawer_layout.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var navigation: WordsWorldNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.drawer_layout)

        navigation = WordsWorldNavigation()
        navigation.init(this, this.supportFragmentManager)


        navButton.setOnClickListener { drawerLayout.openDrawer(GravityCompat.START, true) }

        setSupportActionBar(topToolBar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(ComponentName(this, "SearchResultsActivity")))
                return true
    }

    private fun buttonEffect(button: View, color: Int) {
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.background.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
                    v.invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    v.background.clearColorFilter()
                    v.invalidate()
                }
            }
            false
        }
    }

    fun onBottomButtonClick(v: View) {
        val x = false
        if (v.isPressed) {
            when (v.id) {
                R.id.settingsButton -> viewPager.setCurrentItem(4, true)

                R.id.searchButton -> viewPager.setCurrentItem(3, true)

                R.id.heartButton -> viewPager.setCurrentItem(2, true)

                R.id.profileButton -> viewPager.setCurrentItem(1, true)

                R.id.homeButton -> viewPager.setCurrentItem(0, true)
            }
        }
    }
    /*          ----------*****     FUNCTIONALITY METHODS     *****----------          */

    fun loadSharedPreferences() {
        val mainConfig = Configuration(resources.configuration)
        val sP = PreferenceManager.getDefaultSharedPreferences(this)
        val value = sP.getString("language", Locale.getDefault().toString())     // co zwraca Locale.getDefault.toString()??
        val locale = Locale(value)
        Locale.setDefault(locale)
        mainConfig.setLocale(locale)
        resources.updateConfiguration(mainConfig, null)
    }
}