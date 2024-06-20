package com.example.assignmentgenius;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    private TextView textViewEmailAddress;
    private TextView textViewPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Initialize views
        ImageView imageViewFacebook = findViewById(R.id.imageViewFacebook);
        ImageView imageViewTwitter = findViewById(R.id.imageViewTwitter);
        ImageView imageViewInstagram = findViewById(R.id.imageViewInstagram);

        ImageView imageViewPhoneIcon = findViewById(R.id.imageViewPhoneIcon);
        ImageView imageViewEmailIcon = findViewById(R.id.imageViewEmailIcon);

        textViewEmailAddress = findViewById(R.id.textViewEmailAddress);
        textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);

        // Set click listeners for social media icons
        imageViewFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSocialMedia("https://facebook.com", "com.facebook.katana");
            }
        });

        imageViewTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSocialMedia("https://twitter.com", "com.twitter.android");
            }
        });

        imageViewInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSocialMedia("https://instagram.com", "com.instagram.android");
            }
        });

        // Set click listeners for email and phone icons
        imageViewEmailIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeEmail();
            }
        });

        imageViewPhoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber();
            }
        });
    }

    private void openSocialMedia(String webUrl, String appPackageName) {
        try {
            Intent intent = getPackageManager().getLaunchIntentForPackage(appPackageName);
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                // App isn't installed, open social media web URL in browser
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
                startActivity(webIntent);
            }
        } catch (ActivityNotFoundException e) {
            // If no app is available, open social media web URL in browser
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
            startActivity(webIntent);
        }
    }

    private void composeEmail() {
        String emailAddress = textViewEmailAddress.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + emailAddress)); // only email apps should handle this

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show();
        }
    }

    private void dialPhoneNumber() {
        String phoneNumber = textViewPhoneNumber.getText().toString();

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No dialer app found", Toast.LENGTH_SHORT).show();
        }
    }
}
