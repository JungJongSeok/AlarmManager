package com.AlarmManager.test;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        NotificationManager notiManager
                = (NotificationManager)
                context.getSystemService(context.NOTIFICATION_SERVICE);
        Notification noti = new Notification(R.mipmap.ic_launcher,
                "노티",
                System.currentTimeMillis());
        noti.flags = noti.flags | Notification.FLAG_ONGOING_EVENT;//두가지의 조건
        notiManager.notify(1, noti);
    }
}

