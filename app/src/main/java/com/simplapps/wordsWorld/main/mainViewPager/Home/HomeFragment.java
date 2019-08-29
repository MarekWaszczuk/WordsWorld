package com.simplapps.wordsWorld.main.mainViewPager.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.simplapps.wordsWorld.LearnWordsActivity;
import com.simplapps.wordsWorld.R;

public class HomeFragment extends Fragment {

    private ConstraintLayout changingLayout;
    private Button learnWordsButton, playAGameButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        changingLayout = (ConstraintLayout) inflater.inflate(R.layout.home_fragment, container, false);
        learnWordsButton = changingLayout.findViewById(R.id.learnWords);
        playAGameButton = changingLayout.findViewById(R.id.playAGame);
        learnWordsButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LearnWordsActivity.class);
            startActivity(intent);
        });
        return changingLayout;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
