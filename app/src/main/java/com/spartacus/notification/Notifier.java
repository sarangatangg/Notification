package com.spartacus.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by sarangatangg on 4/13/15.
 */
public class Notifier {

    private int notificationID = 100;

    protected void createNotification (Context context) {

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(context);
        nBuilder.setContentTitle("Notification");
        nBuilder.setContentText("This is a notification");
        nBuilder.setSmallIcon(R.drawable.ic_launcher);
        // nBuilder.setContentIntent(getMainActivityPendingIntent());
        nBuilder.setAutoCancel(true);

        // Notification notification = nBuilder.build();

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(notificationID, nBuilder.build());
    }

    protected PendingIntent getMainActivityPendingIntent (Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1234, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return (pendingIntent);
    }

}
