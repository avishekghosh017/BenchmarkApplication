package com.example.avigo.hellloworld;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.avigo.hellloworld.R;

import java.io.IOException;

public class AudioPlayerActivity extends AppCompatActivity {
    private String audioFilePath;
    private MediaPlayer mediaPlayer;

    public void playAudio(View view){
        try{
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
                Toast.makeText(this, "Select Audio File First !!", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){

        }
    }

    public void stopAudio(View view){
        try{
            if(mediaPlayer != null)
                mediaPlayer.stop();
            else
                Toast.makeText(this, "Play a Song First!!! ", Toast.LENGTH_LONG).show();
        }catch (Exception e){

        }
    }
    public void selectAudio(View view){
        Intent intentSelectAudion = new Intent(Intent.ACTION_GET_CONTENT);
        intentSelectAudion.setType("file/*");
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
        setContentView(R.layout.activity_audio_player);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_audio_player, menu);
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
