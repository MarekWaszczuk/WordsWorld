package com.simplapps.wordsWorld.main.mainViewPager

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.simplapps.wordsWorld.R
import kotlinx.android.synthetic.main.fragment_main_view_pager.*

class ViewPagerFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_view_pager, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerAdapter(fragmentManager!!)
        mainViewPager.adapter = adapter
        initTabs()

    }

    private fun initTabs() {
        tabLayout.setupWithViewPager(mainViewPager)
        var k = 0
        while(k < tabLayout.tabCount) {
            when(k) {
                0 -> tabLayout.getTabAt(k)?.setIcon(R.drawable.ic_home_button)
                1 -> tabLayout.getTabAt(k)?.setIcon(R.drawable.ic_question_mark)
                2 -> tabLayout.getTabAt(k)?.setIcon(R.drawable.ic_heart)
                3 -> tabLayout.getTabAt(k)?.setIcon(R.drawable.ic_search)
                else -> tabLayout.getTabAt(k)?.setIcon(R.drawable.ic_settings)
            }
            k++
        }
    }


}
