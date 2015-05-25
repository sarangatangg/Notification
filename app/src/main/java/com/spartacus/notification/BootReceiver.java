package com.spartacus.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    public BootReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            // show alarm here
            Alarm alarm = new Alarm();
            alarm.setAlarm(context);
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
