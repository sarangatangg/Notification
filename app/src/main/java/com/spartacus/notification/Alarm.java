package com.spartacus.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import java.util.Calendar;

/**
 * Created by sarangatangg on 4/12/15.
 */
public class Alarm {

    protected PendingIntent getMainActivityPendingIntent (Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1234, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return (pendingIntent);
    }

    protected PendingIntent getBroadcastActivityPendingIntent(Context context) {
        Intent intent = new Intent(context, AlarmBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        return(pendingIntent);
    }



    protected void setAlarm(Context context) {
        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        /* alarmMgr.set(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 10 * 1000,
                getMainActivityPendingIntent());*/

/*        alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 10 * 1000,
                10 * 1000,
                getMainActivityPendingIntent());*/

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        calendar.set(Calendar.MINUTE, 30);
        long milliseconds = calendar.getTimeInMillis();

        alarmMgr.setInexactRepeating(AlarmManager.RTC,
                milliseconds,
                AlarmManager.INTERVAL_DAY,
                // getMainActivityPendingIntent(context)
                getBroadcastActivityPendingIntent(context));

        ComponentName bootReceiver = new ComponentName(context, BootReceiver.class);
        PackageManager packageManager = context.getPackageManager();

        packageManager.setComponentEnabledSetting(bootReceiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);

    }

    protected void cancelAlarm(Context context) {
        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        // alarmMgr.cancel(getMainActivityPendingIntent(context)
        alarmMgr.cancel(getBroadcastActivityPendingIntent(context));

        ComponentName receiver = new ComponentName(context, BootReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);

    }


}
