package com.example.avigo.hellloworld;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;


public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Broadcast called",Toast.LENGTH_SHORT).show();
        Log.i("TTT","OnReceive called");
        Intent startServiceIntent = new Intent(context, BootService.class);
        context.startService(startServiceIntent);
    }
}