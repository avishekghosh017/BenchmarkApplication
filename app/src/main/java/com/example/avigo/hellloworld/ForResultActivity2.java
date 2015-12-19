package com.example.avigo.hellloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ForResultActivity2 extends AppCompatActivity {

    public void saveUserInfo(View view){
        String name = ((EditText)findViewById(R.id.etNameResult)).getText().toString();
        Intent intent = new Intent();
        intent.putExtra("name",name);
        setResult(RESULT_OK, intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result2);
    }
}
