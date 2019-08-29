package com.simplapps.wordsWorld.main.mainViewPager.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

import com.simplapps.wordsWorld.R

class SearchFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.search_fragment, container, false) as ConstraintLayout
    }

    override fun onPause() {
        super.onPause()
    }
}