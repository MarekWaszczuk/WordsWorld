package com.simplapps.WordWorld;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainMenuActivity extends AppCompatActivity {

    Toolbar menuBar, bottomToolbar;
    NavigationView navView;
    private Button learnWordsButton, playAGameButton;
    private AppCompatButton navButton, homeButton, profileButton, settingsButton, searchButton, heartButton;
    DrawerLayout drawerLayout;
    List<Button> bottomButtons;
    ConstraintLayout changingLayout;
    TextView tw1, tw2, tw3, tw4;
    Configuration mainConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        bottomToolbar = findViewById(R.id.bottomToolBar);
        navView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        initBottomButtons();
        navButton = findViewById(R.id.nav_button);
        learnWordsButton = findViewById(R.id.learnWords);
        playAGameButton = findViewById(R.id.playAGame);
        learnWordsButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, LearnWordsActivity.class);
            startActivity(intent);
        });
        navButton.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START, true);

        });
        buttonEffect(navButton, 0xe0f47521);
        buttonEffect(learnWordsButton, 0xe0f47521);
        buttonEffect(playAGameButton, 0xe0f47521);
        menuBar = findViewById(R.id.topToolBar);
        bottomButtonColorEffect( 0xe0E71D36, bottomButtons);
        bottomButtonColorEffect( 0xe0E71D36, bottomButtons);
        homeButton.setPressed(true);
        bottomButtonColorEffect(0xe0E71D36, bottomButtons);
        setSupportActionBar(menuBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);             // TITLE DISABLED
        changingLayout = findViewById(R.id.changingLayout);
        tw1 = findViewById(R.id.Settings);
        tw2 = findViewById(R.id.Profile);
        tw3 = findViewById(R.id.Search);
        tw4 = findViewById(R.id.Favourite);
        changingLayout.removeAllViews();
        showHomeLayout();
        loadSharedPreferences();
    }

    /*  ------------------*****       UI METHODS       *****-------------------         */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, SearchResultsActivity.class)));
        return true;
    }

    public void initBottomButtons () {
        bottomButtons = new ArrayList<>();
        homeButton = findViewById(R.id.homeButton);
        profileButton = findViewById(R.id.profileButton);
        heartButton = findViewById(R.id.heartButton);
        searchButton = findViewById(R.id.searchButton);
        settingsButton = findViewById(R.id.settingsButton);

        bottomButtons.add(homeButton);
        bottomButtons.add(profileButton);
        bottomButtons.add(heartButton);
        bottomButtons.add(searchButton);
        bottomButtons.add(settingsButton);

    }

    public void onBottomButtonClick(View v) {
        boolean x = false;
        if(v.isPressed()) {
            changingLayout.removeAllViews();
            switch (v.getId()) {
                case R.id.settingsButton:
                    showSettingsLayout();
                    break;

                case R.id.searchButton:
                    showSearchLayout();
                    break;

                case R.id.heartButton:
                    showFavouriteLayout();
                    break;

                case R.id.profileButton:
                    showProfileLayout();
                    break;

                case R.id.homeButton:
                    showHomeLayout();
                    break;
            }

            for (Button b : bottomButtons) {
                b.setPressed(false);
            }
            v.setPressed(true);
            bottomButtonColorEffect(0xe0E71D36, bottomButtons);
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


    public static void bottomButtonColorEffect(int color, List<Button> bottomButtons) {
        for(Button b : bottomButtons){
            Drawable drawable[] = b.getCompoundDrawables();
            if(b.isPressed()) {
                if(drawable[1] != null) {
                    drawable[1].setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                    b.setTextColor(color);                                                     //     POKI CO JEST IF BO TYLKO 1 BUTTON JEST ZROBIONY Z DRAWABLEM!!
                }
                b.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                b.invalidate();
            } else {
                if(drawable[1] != null) {
                    drawable[1].setColorFilter(0xe0999999, PorterDuff.Mode.SRC_ATOP);
                    b.setTextColor(Color.TRANSPARENT);
                }
                b.getBackground().setColorFilter(0xe0999999, PorterDuff.Mode.SRC_ATOP);  // before 0xe0DDE1E4 - szary jasny, 0xe0D1321- czarny, 0xe0999999 - szary ciemniejszy
                b.invalidate();
            }
        }
    }

    public void showHomeLayout() {
        changingLayout.addView(playAGameButton, 0);
        changingLayout.addView(learnWordsButton, 1);
    }

    public void showSettingsLayout() {
        if(findViewById(R.id.changingLayout) != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.changingLayout , new MySettingsFragment()).commit();
        }
    }

    public void showProfileLayout() {
        changingLayout.addView(tw2, 0);
    }

    public void showSearchLayout() {
    }

    public void showFavouriteLayout() {
        changingLayout.addView(tw4, 0);
    }

    /*          ----------*****     BACKEND METHODS     *****----------          */

    public void loadSharedPreferences() {
        mainConfig = new Configuration(getResources().getConfiguration());
        SharedPreferences sP = PreferenceManager.getDefaultSharedPreferences(this);
        String value = sP.getString("language", "");
        Locale locale = new Locale(value);
        Locale.setDefault(locale);
        mainConfig.setLocale(locale);
        getResources().updateConfiguration(mainConfig, null);
    }

}
