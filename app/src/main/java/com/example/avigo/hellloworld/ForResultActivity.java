package com.example.avigo.hellloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ForResultActivity extends AppCompatActivity {

    private Button btnPersonalDetails;
    private final static int PERSONAL_DETAILS = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);
        btnPersonalDetails = (Button) findViewById(R.id.btnPersonalDetails);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ForResultActivity2.class);
                startActivityForResult(intent, PERSONAL_DETAILS);
            }
        };
        btnPersonalDetails.setOnClickListener(onClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.i("bitsnsweets", "Request code : " + requestCode + " result code : " + resultCode);
        if(resultCode == RESULT_OK && requestCode == PERSONAL_DETAILS){
            String name = intent.getStringExtra("name");
            Toast.makeText(getBaseContext(), "namaste " + name, Toast.LENGTH_LONG).show();
        }
    }
}
