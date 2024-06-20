package com.example.assignmentgenius;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    private static final String PREF_THEME = "pref_theme";
    private static final int THEME_LIGHT = R.style.AppTheme;
    private static final int THEME_DARK = R.style.AppTheme_Dark;

    private Switch switchNotifications;
    private Switch switchDarkMode;
    private Switch switchLocation;
    private Button buttonTheme;
    private Button buttonFeedback;
    private Button buttonLanguage;
    private TextView textVersion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // Load the theme from shared preferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int theme = preferences.getInt(PREF_THEME, THEME_LIGHT);
        setTheme(theme); // Apply the theme before setContentView

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // Initialize UI components
        switchNotifications = findViewById(R.id.switch_notifications);
        switchDarkMode = findViewById(R.id.switch_dark_mode);
        switchLocation = findViewById(R.id.switch_location);
        buttonTheme = findViewById(R.id.button_theme);
        buttonFeedback = findViewById(R.id.button_feedback);
        buttonLanguage = findViewById(R.id.button_language);
        textVersion = findViewById(R.id.text_version);

        // Set current version
        textVersion.setText("1.0.0");

        // Set initial state of switches based on current theme
        switchDarkMode.setChecked(theme == THEME_DARK);

        // Set up event listeners
        setupEventListeners(preferences);
    }

    private void setupEventListeners(SharedPreferences preferences) {
        // Notifications switch
        switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(SettingActivity.this, "Notifications " + (isChecked ? "enabled" : "disabled"), Toast.LENGTH_SHORT).show();
            // Implement actual notification logic here
        });

        // Dark Mode switch
        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(SettingActivity.this, "Dark Mode " + (isChecked ? "enabled" : "disabled"), Toast.LENGTH_SHORT).show();
            // Implement dark mode switching logic
            setDarkMode(isChecked, preferences);
        });

        // Location switch
        switchLocation.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(SettingActivity.this, "Location Access " + (isChecked ? "enabled" : "disabled"), Toast.LENGTH_SHORT).show();
            // Implement location access logic here
        });

        // Change Theme button
        buttonTheme.setOnClickListener(v -> {
            changeTheme(preferences);
        });

        // Feedback button
        buttonFeedback.setOnClickListener(v -> {
            sendFeedback();
        });

        // Language button
        buttonLanguage.setOnClickListener(v -> {
            changeLanguage();
        });
    }

    private void setDarkMode(boolean isEnabled, SharedPreferences preferences) {
        // Set the theme based on dark mode toggle
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(PREF_THEME, isEnabled ? THEME_DARK : THEME_LIGHT);
        editor.apply();

        // Apply the theme directly to the current activity
        int newTheme = isEnabled ? THEME_DARK : THEME_LIGHT;
        setTheme(newTheme);
        recreate(); // Restart the activity to apply the new theme
    }

    private void changeTheme(SharedPreferences preferences) {
        int currentTheme = preferences.getInt(PREF_THEME, THEME_LIGHT);

        int newTheme = currentTheme == THEME_LIGHT ? THEME_DARK : THEME_LIGHT;

        // Update preferences with new theme
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(PREF_THEME, newTheme);
        editor.apply();

        // Apply the theme directly to the current activity
        setTheme(newTheme);
        recreate(); // Restart the activity to apply the new theme
    }

    private void sendFeedback() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "assignmentgenius1709@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "App Feedback");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Please enter your feedback here...");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SettingActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void changeLanguage() {
        Toast.makeText(SettingActivity.this, "Change Language functionality is not implemented.", Toast.LENGTH_SHORT).show();
        // Implement language change logic here
    }
}
