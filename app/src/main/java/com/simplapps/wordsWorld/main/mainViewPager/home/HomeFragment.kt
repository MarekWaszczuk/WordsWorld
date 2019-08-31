package com.simplapps.wordsWorld.main.mainViewPager.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.simplapps.wordsWorld.R
import com.simplapps.wordsWorld.main.MainActivity
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    private var changingLayout: ConstraintLayout? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false) as ConstraintLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val actv = activity!! as MainActivity
        learnWordsBtn!!.setOnClickListener { actv.navigation.changeFragment(Fragment())
        Log.d("lOLO", "CLOCK")}
    }

    override fun onPause() {
        super.onPause()
    }
}