package com.spartacus.notification;

import android.app.IntentService;
import android.content.Intent;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class NotifyService extends IntentService {

    public NotifyService() {
        super("NotifyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Notifier notifier = new Notifier();
        notifier.createNotification(this);
        AlarmBroadcastReceiver.completeWakefulIntent(intent);
    }

}