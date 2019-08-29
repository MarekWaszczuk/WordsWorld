package com.simplapps.wordsWorld.main.mainViewPager.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

import com.simplapps.wordsWorld.R

class FavouriteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.favourite_fragment, container, false) as ConstraintLayout
    }

    override fun onPause() {
        super.onPause()
    }
}