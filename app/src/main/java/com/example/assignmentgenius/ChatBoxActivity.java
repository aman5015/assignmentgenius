package com.example.assignmentgenius;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ChatBoxActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMessages;
    private EditText inputMessage;
    private ImageButton btnSend, btnMultimedia, voiceCallButton, videoCallButton;
    private Toolbar chatToolbar;
    private List<String> messages;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_box);

        // Set up toolbar
        chatToolbar = findViewById(R.id.chatToolbar);
        setSupportActionBar(chatToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chat with User");
        getSupportActionBar().setSubtitle("Online");

        // Initialize RecyclerView
        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));

        // Initialize message list and adapter
        messages = new ArrayList<>();
        chatAdapter = new ChatAdapter(messages);
        recyclerViewMessages.setAdapter(chatAdapter);

        // Initialize input and buttons
        inputMessage = findViewById(R.id.inputMessage);
        btnSend = findViewById(R.id.btnSend);
        btnMultimedia = findViewById(R.id.btnMultimedia);
        voiceCallButton = findViewById(R.id.voiceCallButton);
        videoCallButton = findViewById(R.id.videoCallButton);

        // Handle Send Button Click
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = inputMessage.getText().toString();
                if (!TextUtils.isEmpty(message)) {
                    sendMessage(message);
                    inputMessage.setText("");
                }
            }
        });

        // Handle Multimedia Button Click
        btnMultimedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMultimediaOptions();
            }
        });

        // Handle Voice Call Button Click
        voiceCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVoiceCall();
            }
        });

        // Handle Video Call Button Click
        videoCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVideoCall();
            }
        });

        // Load messages for offline support
        loadMessages();
    }

    private void sendMessage(String message) {
        // Add the new message to the list
        messages.add(message);
        // Notify the adapter that the data set has changed
        chatAdapter.notifyDataSetChanged();
        // Scroll to the bottom
        recyclerViewMessages.smoothScrollToPosition(messages.size() - 1);
    }

    private void openMultimediaOptions() {
        // Code to open multimedia options
        // Implement multimedia options logic here
    }

    private void startVoiceCall() {
        // Code to start voice call
        // Implement voice call logic here
    }

    private void startVideoCall() {
        // Code to start video call
        // Implement video call logic here
    }

    private void loadMessages() {
        // Code to load messages from local storage for offline support
        // Implement offline message loading logic here
    }
}
