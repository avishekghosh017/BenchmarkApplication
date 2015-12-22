package com.example.avigo.hellloworld;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void generateNotification(View view){
        switch (view.getId()){
            case R.id.btnNotifi:
                getNotification();
                break;
            case R.id.btnPlaySound:
                playing();
                break;
            case R.id.btnVibrate:
                vibrating();
                break;
            case R.id.btnLEDNotifi:
                ledNotfication();
                break;
            case R.id.btnWakeUp:
                wakeUp();
                break;
            case R.id.btnAllAbove:
                playing();
                vibrating();
                break;
        }
    }

    private void wakeUp() {
        Timer timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        PowerManager.WakeLock wakeLock=((PowerManager) getSystemService(POWER_SERVICE)).newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "TAG");
                        wakeLock.acquire();
                    }
                });
            }
        },5000);
    }

    private void ledNotfication() {
        Notification notification=new Notification();
        notification.ledARGB = 0xFFFF0000;
        NotificationManager nm= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, notification);
    }

    private void getNotification() {
        NotificationCompat.Builder buil= new NotificationCompat.Builder(getBaseContext());
        buil.setSmallIcon(R.drawable.icon1);
        Bitmap icon= BitmapFactory.decodeResource(this.getResources(),R.drawable.appicon);
        buil.setLargeIcon(icon);
        buil.setAutoCancel(true);
        buil.setTicker("news news");
        buil.setContentInfo("9");
        buil.setContentText("record 3rd wicket partnership by virat kholi and yuvraj singh, india");
        PendingIntent pi= PendingIntent.getActivity(getBaseContext(),1,new Intent(getBaseContext(),NewsDemoActivity.class),PendingIntent.FLAG_CANCEL_CURRENT);
        buil.setContentIntent(pi);
        buil.setContentTitle("news");
        Notification noti= buil.build();
        NotificationManager nm= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1,noti);
    }

    private void vibrating() {
        Vibrator vb= (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vb.vibrate(1000);
        vb.vibrate(2000);
        vb.vibrate(1000);
    }

    private void playing() {
        MediaPlayer mp= MediaPlayer.create(getBaseContext(), R.raw.mirrors);
        mp.setLooping(false);
        if(mp.isPlaying()){
            Toast.makeText(getBaseContext(), mp.getDuration(), Toast.LENGTH_LONG).show();
        }else{
            mp.start();
        }
    }
}
