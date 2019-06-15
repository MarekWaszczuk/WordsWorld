package com.simplapps.WordWorld;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MyWords {

    private HashMap<Integer, Word> words;
    AssetManager assetManager;

    public MyWords(AssetManager asset) {
        words = new HashMap<>();
        this.assetManager = asset;
        try {
            loadList();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadList() throws IOException {
        InputStream is = assetManager.open("myList.txt");
        try(BufferedReader locfile = new BufferedReader(new InputStreamReader(is))) {
            String input;
            int i = 0;
            while((input = locfile.readLine())!= null) {
                String engWord = input;
                String engDescription = locfile.readLine();
                words.put(i, new Word(engWord, engDescription));
                i++;
            }
        } catch(IOException io) {
            io.printStackTrace();
        }
    }


    public HashMap<Integer, Word> getList() {
        return words;
    }


    Word getWord(int index) {
        return words.get(index);
    }

    public int getSize() {
        return words.size();
    }
}
