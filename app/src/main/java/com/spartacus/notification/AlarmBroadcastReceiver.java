package com.spartacus.notification;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by sarangatangg on 4/14/15.
 */
public class AlarmBroadcastReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent service = new Intent(context, NotifyService.class);
        startWakefulService(context, service);

    }
}
