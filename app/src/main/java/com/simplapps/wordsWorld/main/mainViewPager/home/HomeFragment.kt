package com.simplapps.wordsWorld.main.mainViewPager.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.simplapps.wordsWorld.R

class HomeFragment : Fragment() {

    private var changingLayout: ConstraintLayout? = null
    private var learnWordsButton: Button? = null
    private var playAGameButton: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        changingLayout = inflater.inflate(R.layout.home_fragment, container, false) as ConstraintLayout
        learnWordsButton = changingLayout!!.findViewById(R.id.learnWords)
        playAGameButton = changingLayout!!.findViewById(R.id.playAGame)
        learnWordsButton!!.setOnClickListener { v ->
//            val intent = Intent(context, LearnWordsActivity::class.java)
//            startActivity(intent)
        }
        return changingLayout
    }

    override fun onPause() {
        super.onPause()
    }
}