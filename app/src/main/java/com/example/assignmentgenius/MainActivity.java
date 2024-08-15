package com.example.assignmentgenius;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnUploadAssignment, btnManageAssignment, btnChatbox, btnAssignmentDoer;
    private Button btnSettings, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        btnUploadAssignment = findViewById(R.id.btnUploadAssignment);
        btnManageAssignment = findViewById(R.id.btnManageAssignment);
        btnChatbox = findViewById(R.id.btnChatbox);
        btnAssignmentDoer = findViewById(R.id.btnAssignmentDoer);
        btnSettings = findViewById(R.id.btnSettings);
        btnAbout = findViewById(R.id.btnAbout);

        // Set onClickListeners to navigate to different activities
        btnUploadAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UploadAssignmentActivity.class);
                startActivity(intent);
            }
        });

        btnManageAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManageAssignmentActivity.class);
                startActivity(intent);
            }
        });

        btnChatbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChatBoxActivity.class);
                startActivity(intent);
            }
        });

        btnAssignmentDoer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AssignmentDoerActivity.class);
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}
