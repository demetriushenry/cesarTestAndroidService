package com.example.questionsix;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Toast.makeText(context, "BootReceiver action " + action, Toast.LENGTH_SHORT).show();
        if (Intent.ACTION_BOOT_COMPLETED.equals(action)) {
            startService(context);
        }
    }

    private void startService(Context context) {
        try {
            Toast.makeText(context, "BootReceiver starting Service", Toast.LENGTH_SHORT).show();
            Intent serviceIntent = new Intent(context, EmailThreadService.class);
            context.startService(serviceIntent);
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Toast.makeText(context, "BootReceiver error " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
