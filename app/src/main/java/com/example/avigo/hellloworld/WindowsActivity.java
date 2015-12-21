package com.example.avigo.hellloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WindowsActivity extends AppCompatActivity {
    ImageButton imageButton;
    Button button;
    public static final String NEWS_TYPE = "newstype";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.windows_layout);
    }
    public void navigate(View view){
        switch (view.getId()){
            case R.id.btnGreet:
                Intent intent= new Intent(getBaseContext(),GreetUserActivity.class);
                startActivity(intent);
                break;
            case  R.id.btnBasic:
                Intent calcIntent= new Intent(getBaseContext(),BasicCalculatorActivity.class);
                startActivity(calcIntent);
                break;
            case R.id.btnJokes:
                Intent jokesIntent= new Intent(getBaseContext(),JokesActivity.class);
                startActivity(jokesIntent);
                break;
            case R.id.btnMedia:
                Intent mediacontrollerIntent=new Intent(getBaseContext(),MediaControllerActivity.class);
                startActivity(mediacontrollerIntent);
                break;
            case R.id.btnBench:
                Intent benchmarkIntent = new Intent(getBaseContext(),BenchmarkActivity.class);
                startActivity(benchmarkIntent);
                break;
            case R.id.ibGoogle:
                Intent webViewIntent=new Intent(getBaseContext(),WebViewActivity.class);
                startActivity(webViewIntent);
                break;
            case R.id.ibContext:
                Intent contextMenuIntent=new Intent(getBaseContext(),ContextMenuActivity.class);
                startActivity(contextMenuIntent);
                break;
            case R.id.ibImagePro:
                Intent imageProcessIntent=new Intent(getBaseContext(),ImageProcesActivity.class);
                startActivity(imageProcessIntent);
                break;
            case R.id.ibGoogleNews:
                Intent intentGoogleNews = new Intent(getBaseContext(), NewsActivity.class);
                intentGoogleNews.putExtra(NEWS_TYPE,"Google");
                startActivity(intentGoogleNews);
                break;
            case R.id.ibFelightNews:
                Intent intentFelightNews = new Intent(getBaseContext(), NewsActivity.class);
                intentFelightNews.putExtra(NEWS_TYPE, "Felight");
                startActivity(intentFelightNews);
                break;
            case R.id.btnNotification:
                Intent notificationIntent= new Intent(getBaseContext(),NotificationActivity.class);
                startActivity(notificationIntent);
                break;
            case R.id.ibFlashLight:
                Intent flashIntent= new Intent(getBaseContext(),FlashLightActivity.class);
                startActivity(flashIntent);
                break;
            case R.id.ibSendSms:
                Intent smsIntent=new Intent(getBaseContext(),SendSMSActivity.class);
                startActivity(smsIntent);
                break;
            case R.id.ibActivityForResult:
                Intent forResultIntent=new Intent(getBaseContext(),ForResultActivity.class);
                startActivity(forResultIntent);
                break;
            case R.id.ibAudioPlayer:
                Intent audioPlayerIntent= new Intent(getBaseContext(),AudioPlayerActivity.class);
                startActivity(audioPlayerIntent);
                break;
            case R.id.ibVideoPlayer:
                Intent videoPlayerIntent= new Intent(getBaseContext(),VideoPlayerActivity.class);
                startActivity(videoPlayerIntent);
                break;
            case R.id.ibGesture:
                Intent gestureIntent= new Intent(getBaseContext(),GestureActivity.class);
                startActivity(gestureIntent);
                break;
            case R.id.ibSensor:
                Intent sensorIntent= new Intent(getBaseContext(),SensorListActivity.class);
                startActivity(sensorIntent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("About");
        menu.add("Greet User");
        menu.add("Basic Calc");
        menu.add("Jokes App");
        menu.add("Settings");
        menu.add("exit");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle()=="Greet User"){
            Intent intent= new Intent(getBaseContext(),GreetUserActivity.class);
            startActivity(intent);
        }
        if (item.getTitle()=="Basic Calc"){
            Intent intent= new Intent(getBaseContext(),BasicCalculatorActivity.class);
            startActivity(intent);
        }
        if (item.getTitle()=="Jokes App"){
            Intent intent= new Intent(getBaseContext(),JokesActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
