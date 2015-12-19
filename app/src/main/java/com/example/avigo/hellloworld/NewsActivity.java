package com.example.avigo.hellloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {
    private TextView tvNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_layout);

        tvNews = (TextView) findViewById(R.id.tvNews);


        Intent incommingIntentObject = getIntent();
        Log.i("TTT",incommingIntentObject.getStringExtra(WindowsActivity.NEWS_TYPE));
        setTitle(incommingIntentObject.getStringExtra(WindowsActivity.NEWS_TYPE));
        tvNews.setText(incommingIntentObject.getStringExtra(WindowsActivity.NEWS_TYPE) + "  news \n HA HA HA!!!!");


    }


}
