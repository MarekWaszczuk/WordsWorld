package com.simplapps.WordWorld;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import java.util.Locale;

public class MySettingsFragment extends PreferenceFragmentCompat {

    private ListPreference language;
    private Configuration mainConfig;
    private SwitchPreferenceCompat alphabetical;

    @Override
    public void onStart() {
        super.onStart();
        language = findPreference("language");
        alphabetical = findPreference("alphabeticalOrder");
        mainConfig = new Configuration(getResources().getConfiguration());
        setCustomSummaries();
        setPreferenceChangeListeners();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings);                              // list of setting to display in a layout

    }

    /*  ------------------*****       UI METHODS       *****-------------------         */

    public void setCustomSummaries() {
        language.setSummaryProvider(new Preference.SummaryProvider() {
            @Override
            public CharSequence provideSummary(Preference preference) {
                String text = preference.getTitle().toString();
                if(text.isEmpty()) {
                    return "Not set";
                }
                String summary;
                if(text.equalsIgnoreCase("Język")) {
                    summary = "Polski";
                } else {
                    summary = "English";
                }
                return summary;
            }
        });
    }

    public void refreshPreferencesUI() {
        language.setTitle(getResources().getString(R.string.languagePreference));
    }

    /*  ------------------*****       FUNCTIONALITY METHODS       *****-------------------         */

    public void setPreferenceChangeListeners() {
        language.setOnPreferenceChangeListener((preference, newValue) -> {
            String languageToLoad = (String) newValue;
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            mainConfig.setLocale(locale);
            getResources().updateConfiguration(mainConfig, null);
            refreshPreferencesUI();
            return true;
        });
    }


}
