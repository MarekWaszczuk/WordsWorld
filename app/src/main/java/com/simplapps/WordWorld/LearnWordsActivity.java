package com.simplapps.WordWorld;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;


public class LearnWordsActivity extends AppCompatActivity {

    Button nextWord, showMeaning, backButton;
    AppCompatImageButton previousWord;
    AssetManager assetManager;
    MyWords wordsList;
    TextView engWord, polWord, wordsCount;
    int randomIndex;
    int startIndex = 0;
    String language;
    String wordCountString;
    Boolean isAlphabetical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnwords);
        SharedPreferences sP = PreferenceManager.getDefaultSharedPreferences(this);
        isAlphabetical = sP.getBoolean("alphabeticalOrder", false);
        assetManager = getAssets();
        wordsList = new MyWords(assetManager);

        engWord = findViewById(R.id.englishWord);
        engWord.setTypeface(null, Typeface.BOLD);
        engWord.setText(wordsList.getWord(startIndex).getEngWord());
        polWord = findViewById(R.id.theMeaning);
        wordsCount = findViewById(R.id.wordsCount);
        initWordCounter();
        initButtons();
    }

        /*  ------------------*****       UI METHODS       *****-------------------         */

    public void initButtons() {
        nextWord = findViewById(R.id.nextWordButton);
        showMeaning = findViewById(R.id.showMeaningButton);
        previousWord = findViewById(R.id.previousWordButton);
        backButton = findViewById(R.id.back_button);
        buttonEffect(nextWord, 0xe0E71D36);
        buttonEffect(previousWord, 0xe0E71D36);
        nextWord.getBackground().setColorFilter(0xe0999999, PorterDuff.Mode.SRC_ATOP);
        nextWord.invalidate();
        previousWord.getBackground().setColorFilter(0xe0999999, PorterDuff.Mode.SRC_ATOP);
        previousWord.invalidate();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nextWordButton:
                if(isAlphabetical) {
                    startIndex++;
                    engWord.setText(wordsList.getWord(startIndex).getEngWord());
                } else {
                    startIndex = (int) (Math.random() * wordsList.getList().size());
                    engWord.setText(wordsList.getWord(startIndex).getEngWord());
                }
                wordsCount.setText(wordCountString + startIndex + "/" + wordsList.getSize());
                polWord.setText("");
                break;

            case R.id.previousWordButton:
                if(isAlphabetical) {
                    startIndex--;
                    engWord.setText(wordsList.getWord(startIndex).getEngWord());
                } else {
                    startIndex = (int) (Math.random() * wordsList.getList().size());
                    engWord.setText(wordsList.getWord(startIndex).getEngWord());
                }
                wordsCount.setText(wordCountString + startIndex + "/" + wordsList.getSize());
                polWord.setText("");
                break;

            case R.id.addToFavouritesButton:

                break;

            case R.id.back_button:
                Intent intent = new Intent(LearnWordsActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.showMeaningButton:
                polWord.setText(wordsList.getWord(startIndex).getEngMeaning());
                break;

        }
    }

    public static void buttonEffect(View button, int color) {
        button.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }

        /*          ----------*****     FUNCTIONALITY METHODS     *****----------          */



    public void initWordCounter() {
        wordsCount.setTypeface(null, Typeface.BOLD);
        SharedPreferences sP = PreferenceManager.getDefaultSharedPreferences(this);
        language = sP.getString("language", "");
        if(language.equalsIgnoreCase("pl")) {
            wordCountString = "Słowo: ";
        } else {
            wordCountString = "Word: ";
        }
        wordsCount.setText(wordCountString + startIndex + "/" + wordsList.getSize());
    }
}