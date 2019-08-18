package com.simplapps.wordsWorld;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

public class SearchResultsActivity extends Activity {

    HashMap<Integer, Word> wordsData;
    MyWords myWords;
    LinearLayout layout;
    String query;
    AssetManager assetManager;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.search_activity);
        assetManager = getAssets();
        myWords = new MyWords(assetManager);
        wordsData = myWords.getList();
        layout = findViewById(R.id.searchLayout);
        tv = findViewById(R.id.searchResult);


        searchForWord(query);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
        }
    }

    private void searchForWord(String query) {
        tv.setText("Word not found.");
        for(int k=0; k < wordsData.size(); k++) {
            if(query.equalsIgnoreCase(wordsData.get(k).getEngWord())) {
                tv.setText(wordsData.get(k).getEngWord());
            }
        }


    }

}

