package com.example.avigo.hellloworld;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MediaControllerActivity extends Activity {
    ImageView imageView;
    ImageButton imageButton;
    boolean temp=true;
    static private String audioFilePath;
    static private MediaPlayer mediaPlayer;

    public void playAudio(View view){
        if(audioFilePath != null){
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mediaPlayer.setDataSource(audioFilePath);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Please select Audio File First !!", Toast.LENGTH_LONG).show();
        }
    }

    public void stopAudio(View view){
        if(mediaPlayer != null)
            mediaPlayer.stop();
        else
            Toast.makeText(this, "Yo Yo dude.. play a song first !!! ", Toast.LENGTH_LONG).show();
    }
    public void selectAudio(View view){
        Intent intentSelectAudion = new Intent(Intent.ACTION_GET_CONTENT);
        intentSelectAudion.setType("file/*.mp3");
        startActivityForResult(intentSelectAudion, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        audioFilePath = intent.getData().getPath();
        Toast.makeText(this, audioFilePath, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediacontroller_layout);
        imageButton=(ImageButton) findViewById(R.id.ibPlayPause);
        imageView=(ImageView) findViewById(R.id.imvMusic);
    }

    public void changePlayPause(View view){
        switch (view.getId()){
            case R.id.ibPlayPause:
                if(temp==true){
                    imageButton.setImageResource(R.drawable.pause);

                    if(audioFilePath != null){
                        mediaPlayer = new MediaPlayer();
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        try {
                            mediaPlayer.setDataSource(audioFilePath);
                            mediaPlayer.prepare();
                            mediaPlayer.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(this, "Please select Audio File First !!", Toast.LENGTH_LONG).show();
                    }

                }else {
                    imageButton.setImageResource(R.drawable.play);

                    if(mediaPlayer != null)
                        mediaPlayer.stop();
                    else
                        Toast.makeText(this, "Yo Yo dude.. play a song first !!! ", Toast.LENGTH_LONG).show();

                }
                temp = !temp;
                break;
        }
    }

    public void nextPrevious(View view){
        switch (view.getId()){
            case R.id.ibNext:
                imageView.setImageResource(R.drawable.musica);
                Toast.makeText(this,"you have reached the end",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ibPrevious:
                imageView.setImageResource(R.drawable.musicb);
                Toast.makeText(this,"you have reached the beginging",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
