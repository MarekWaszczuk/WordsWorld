package com.simplapps.WordWorld;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
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
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainMenuActivity extends AppCompatActivity {

    Toolbar menuBar, bottomToolbar;
    NavigationView navView;

    private AppCompatButton navButton, homeButton, profileButton, settingsButton, searchButton, heartButton;
    DrawerLayout drawerLayout;
    List<Button> bottomButtons;
    FrameLayout fragmentContainer;
    TextView tw1, tw2, tw3, tw4;
    Configuration mainConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        loadSharedPreferences();
        bottomToolbar = findViewById(R.id.bottomToolBar);
        navView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        initBottomButtons();
        homeButton.setPressed(true);
        navButton = findViewById(R.id.nav_button);

        navButton.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START, true);

        });
        buttonEffect(navButton, 0xe0f47521);
//        buttonEffect(learnWordsButton, 0xe0f47521);
//        buttonEffect(playAGameButton, 0xe0f47521);
        menuBar = findViewById(R.id.topToolBar);
        bottomButtonColorEffect( 0xe0E71D36, bottomButtons);
        setSupportActionBar(menuBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);             // TITLE DISABLED
        fragmentContainer = findViewById(R.id.fragment_container);
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

    /*     BOTTOM TOOLBAR BUTTONS     */

    public void onBottomButtonClick(View v) {
        boolean x = false;
        if(v.isPressed()) {
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

    /*     COLOR WHEN PRESSED     */

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

    /*     BOTTOM BUTTON IS RED WHEN ACTIVE     */

    public static void bottomButtonColorEffect(int color, List<Button> bottomButtons) {
        for(Button b : bottomButtons){
            Drawable drawable[] = b.getCompoundDrawables();
            if(b.isPressed()) {
                drawable[1].setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                b.setTextColor(color);                                                     //     POKI CO JEST IF BO TYLKO 1 BUTTON JEST ZROBIONY Z DRAWABLEM!!
            } else {
                drawable[1].setColorFilter(0xe0999999, PorterDuff.Mode.SRC_ATOP);
                b.setTextColor(Color.TRANSPARENT);
            }
        }
    }

    public void showHomeLayout() {
        if(findViewById(R.id.fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right).replace(R.id.fragment_container , new HomeFragment()).commit();
        }
    }

    public void showSettingsLayout() {
        if(findViewById(R.id.fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right).replace(R.id.fragment_container , new MySettingsFragment()).commit();
        }
    }

    public void showProfileLayout() {
        if(findViewById(R.id.fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right).replace(R.id.fragment_container , new ProfileFragment()).commit();
        }
    }

    public void showSearchLayout() {
        if(findViewById(R.id.fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right).replace(R.id.fragment_container , new SearchFragment()).commit();
        }
    }

    public void showFavouriteLayout() {
        if(findViewById(R.id.fragment_container) != null) {
            getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right).replace(R.id.fragment_container , new FavouriteFragment()).commit();
        }
    }

    /*          ----------*****     FUNCTIONALITY METHODS     *****----------          */

    public void loadSharedPreferences() {
        mainConfig = new Configuration(getResources().getConfiguration());
        SharedPreferences sP = PreferenceManager.getDefaultSharedPreferences(this);
        String value = sP.getString("language", Locale.getDefault().toString());     // co zwraca Locale.getDefault.toStrong()??
        Locale locale = new Locale(value);
        Locale.setDefault(locale);
        mainConfig.setLocale(locale);
        getResources().updateConfiguration(mainConfig, null);
    }

}
