package com.simplapps.wordsWorld.main.mainViewPager.Search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.simplapps.wordsWorld.R;

public class SearchFragment extends Fragment {

    ConstraintLayout changingLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        changingLayout = (ConstraintLayout) inflater.inflate(R.layout.search_fragment, container, false);
        return changingLayout;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}