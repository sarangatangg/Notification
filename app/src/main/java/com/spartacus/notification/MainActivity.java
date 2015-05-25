package com.spartacus.notification;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    // private int notificationID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button notificationButton = (Button) findViewById(R.id.button);
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification ();
            }
        });


        Button alarmButton = (Button) findViewById(R.id.button2);
        alarmButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setAlarm();
            };

        });

        Button cancelAlarmButton = (Button) findViewById(R.id.button3);
        cancelAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();

            }
        });


    }

    protected void displayNotification(){
/*        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this);
        nBuilder.setContentTitle("Notifcation");
        nBuilder.setContentText("This is a notification");
        nBuilder.setSmallIcon(R.drawable.ic_launcher);
        // nBuilder.setContentIntent(getMainActivityPendingIntent());
        nBuilder.setAutoCancel(true);

        // Notification notification = nBuilder.build();

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(notificationID, nBuilder.build());*/

        Notifier notifier = new Notifier();
        notifier.createNotification(this);

    }
/*
    protected PendingIntent getMainActivityPendingIntent () {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1234, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return (pendingIntent);
    }*/



    protected void setAlarm() {
       /*AlarmManager alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
 alarmMgr.set(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 10 * 1000,
                getMainActivityPendingIntent());


        alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + 10 * 1000,
                10 * 1000,
                getMainActivityPendingIntent());


        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        calendar.set(Calendar.MINUTE, 30);
        long milliseconds = calendar.getTimeInMillis();

        alarmMgr.setInexactRepeating(AlarmManager.RTC,
                milliseconds,
                AlarmManager.INTERVAL_DAY,
                getMainActivityPendingIntent());*/

        Alarm alarm = new Alarm ();
        alarm.setAlarm(this);

        }

    protected void cancelAlarm() {
/*        AlarmManager alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmMgr.cancel(getMainActivityPendingIntent());*/

        Alarm alarm = new Alarm();
        alarm.cancelAlarm(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
