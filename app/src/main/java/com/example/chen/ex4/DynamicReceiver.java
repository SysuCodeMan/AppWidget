package com.example.chen.ex4;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.RemoteViews;

/**
 * Created by Chen on 2016/10/20.
 */

public class DynamicReceiver extends BroadcastReceiver {
    private static String DYNAMICACTION = "com.example.chen.ex4.dynamicreceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(DYNAMICACTION)) {
            RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_demo);
            Bundle bundle = intent.getExtras();
            String message = bundle.getString("message");

            rv.setImageViewResource(R.id.widget_image, R.mipmap.dynamic);
            rv.setTextViewText(R.id.appwidget_text, message);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            appWidgetManager.updateAppWidget(new ComponentName(context, WidgetDemo.class), rv);
        }
    }
}
