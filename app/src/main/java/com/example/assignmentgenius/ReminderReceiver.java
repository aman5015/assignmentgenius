// ReminderReceiver.java
package com.example.assignmentgenius;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

public class ReminderReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String assignmentTitle = intent.getStringExtra("assignmentTitle");

        // Send SMS alert
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("PHONE_NUMBER", null,
                "Reminder: Your assignment \"" + assignmentTitle + "\" is due in 24 hours!", null, null);

        Toast.makeText(context, "SMS reminder sent for " + assignmentTitle, Toast.LENGTH_SHORT).show();
    }
}
