package com.simplapps.wordsWorld.shared.extensions

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainTabLayout : TabLayout {

    private val titles: MutableList<String> = arrayListOf()

    constructor(context: Context?) : super(context) {
        init(context, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
    }

    override fun setupWithViewPager(viewPager: ViewPager?) {
        super.setupWithViewPager(viewPager)

        addViews()
    }

    private fun createTexts(): AppCompatTextView {
        val customTextView = AppCompatTextView(context)
        customTextView.gravity = Gravity.CENTER
        if(titles.isEmpty() || titles.size < tabCount) {
            var text = ""
            when(titles.size) {
                0 -> text = "Home"
                1 -> text = "Profile"
                    2 -> text = "Favourites"
                3 -> text = "Search"
                else -> text = "Settings"
            }
            customTextView.text = text
            titles.add(text)
        }

        return customTextView
    }

    private fun addViews() {
        for (i in 0 until tabCount) {
            val tab  = getTabAt(i)
            if(tab != null) {
                val customTextView = createTexts()
                tab.customView = customTextView
            }
        }
    }


}