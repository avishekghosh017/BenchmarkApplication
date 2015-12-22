package com.example.avigo.hellloworld;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

public class SharedPreferenceActivity extends AppCompatActivity {

    private RelativeLayout myLayout;
    private final String MY_PREF = "MyPref";
    private final String BG_KEY = "bg_key";
    private SharedPreferences preferences;

    public void changeBg(View view){
        SharedPreferences.Editor editor = preferences.edit();
        switch (view.getId()){
            case R.id.rbBlue:
                myLayout.setBackgroundColor(Color.BLUE);
                editor.putInt(BG_KEY, Color.BLUE);
                editor.commit();
                break;

            case R.id.rbWhite:
                myLayout.setBackgroundColor(Color.WHITE);
                editor.putInt(BG_KEY, Color.WHITE);
                editor.commit();
                break;

            case R.id.rbYellow:
                myLayout.setBackgroundColor(Color.YELLOW);
                editor.putInt(BG_KEY, Color.YELLOW);
                editor.commit();
                break;

            case R.id.rbRed:
                myLayout.setBackgroundColor(Color.RED);
                editor.putInt(BG_KEY, Color.RED);
                editor.commit();
                break;

            case R.id.rbGrey:
                myLayout.setBackgroundColor(Color.GRAY);
                editor.putInt(BG_KEY, Color.GRAY);
                editor.commit();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        myLayout = (RelativeLayout) findViewById(R.id.myLayout);
        preferences = getSharedPreferences(MY_PREF,MODE_PRIVATE);

        myLayout.setBackgroundColor(preferences.getInt(BG_KEY, Color.WHITE));
    }
}
