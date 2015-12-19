package com.example.avigo.hellloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by AviGo on 11/25/2015.
 */
public class GreetUserActivity extends Activity{
    EditText etName;
    TextView greetUser;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.greet_user_activity);
        etName= (EditText) findViewById(R.id.etName);
        greetUser= (TextView) findViewById(R.id.tvResult);
        btnSubmit= (Button) findViewById(R.id.btn);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetUser.setText("Hello "+etName.getText());
            }
        });
    }

}
