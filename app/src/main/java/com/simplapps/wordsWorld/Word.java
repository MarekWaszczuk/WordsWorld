package com.simplapps.wordsWorld;

public class Word {

    private String engWord;
    private String engMeaning;

    public Word(String eng, String engDescription) {
        this.engWord = eng;
        this.engMeaning = engDescription;
    }

    public String getEngWord() {
        return engWord;
    }

    public String getEngMeaning() {

        return engMeaning;
    }
}
