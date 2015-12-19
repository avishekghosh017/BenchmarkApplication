package com.example.avigo.hellloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by AviGo on 12/1/2015.
 */
public class BasicCalculatorActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
    }

    public void doCalculation(View view){
        EditText etFirstNum= (EditText) findViewById(R.id.etFirstNum);
        EditText etSecondNum= (EditText) findViewById(R.id.etSecondNum);
        TextView tvResult= (TextView) findViewById(R.id.tvResult);

        double num1=0,num2=0;

        try {
            num1 = Double.parseDouble(etFirstNum.getText().toString());
            num2 = Double.parseDouble(etSecondNum.getText().toString());
        }catch(Exception e){
            e.printStackTrace();
        }

        switch (view.getId()){
            case R.id.btnAdd:
                tvResult.setText("Add = "+ (num1+num2));
                break;
            case R.id.btnSub:
                tvResult.setText("Sub = "+ (num1-num2));
                break;
            case R.id.btnMul:
                tvResult.setText("Mul = "+ (num1*num2));
                break;
            case R.id.btnDiv:
                tvResult.setText("Div = "+ (num1/num2));
                break;
            case R.id.btnMod:
                tvResult.setText("Mod = "+ (num1%num2));
                break;
        }
    }
}
