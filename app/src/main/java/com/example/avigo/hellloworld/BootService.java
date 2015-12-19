package com.example.avigo.hellloworld;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class BootService extends Service {
    public BootService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("TTT","Onstart");
        MediaPlayer mp= MediaPlayer.create(getBaseContext(), R.raw.mirrors);
        mp.setLooping(false);
        mp.start();

        customNotification();
        return super.onStartCommand(intent, flags, startId);
    }

    public void customNotification() {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(getBaseContext());
        builder.setSmallIcon(R.drawable.icon1);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icon2));
        builder.setTicker("Breaking news");
        builder.setContentInfo("10");
        builder.setContentText("India wins the series against australia 3-2");
        builder.setContentTitle("Series win");
        PendingIntent pendingIntent=PendingIntent.getActivity(getBaseContext(),1,new Intent(getBaseContext(),WindowsActivity.class),PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pendingIntent);

        Notification notification=builder.build();

        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }
}
