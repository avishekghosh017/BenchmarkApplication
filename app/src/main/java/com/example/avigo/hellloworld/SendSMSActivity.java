package com.example.avigo.hellloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

import com.example.avigo.hellloworld.R;

public class SendSMSActivity extends AppCompatActivity {

    EditText etPhone;
    EditText etMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        etPhone=(EditText) findViewById(R.id.etPhone);
        etMsg=(EditText) findViewById(R.id.etMsg);
    }

    public void sendMessage(View view){
        String number = etPhone.getText().toString();
        String msg= etMsg.getText().toString();
        switch (view.getId()){
            case R.id.btnSend:
                SmsManager smsManager= SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,msg,null,null);
        }
    }
}
