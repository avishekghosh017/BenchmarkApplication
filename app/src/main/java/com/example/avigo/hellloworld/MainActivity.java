package com.example.avigo.hellloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navigation(View view){
        switch (view.getId()){
            case R.id.btnGU:
                Intent intent= new Intent(getBaseContext(),GreetUserActivity.class);
                startActivity(intent);
                break;
            case  R.id.btnBasic:
                Intent intent1= new Intent(getBaseContext(),BasicCalculatorActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnJokes:
                Intent intent2= new Intent(getBaseContext(),JokesActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnMC:
                Intent intent3=new Intent(getBaseContext(),MediaControllerActivity.class);
                startActivity(intent3);
                break;
            case R.id.btnGoo:
                Intent intent4=new Intent(getBaseContext(),WebViewActivity.class);
                startActivity(intent4);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Greet User");
        menu.add("Basic Calc");
        menu.add("Jokes App");

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
