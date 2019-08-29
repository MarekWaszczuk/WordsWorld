package com.simplapps.wordsWorld

import android.content.res.AssetManager
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class MyWords(val assetManager: AssetManager) {

    lateinit var wordsList: HashMap<Int, Word>

    init {
        loadlist()
    }

/* LOADING WORDS FROM TXT  */

    private fun loadlist() {
        val ins: InputStream = assetManager.open("myList.txt")

        try {
            val locfile = BufferedReader(InputStreamReader(ins))
            var engWord = ""
            var engMeaning = ""
            var i = 0
            while (locfile.readLine() != null) {
                engWord = locfile.readLine()
                engMeaning = locfile.readLine()
                wordsList.put(i, Word(engWord, engMeaning))
                i++
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}