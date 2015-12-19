package com.example.avigo.hellloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BenchmarkActivity extends Activity {
    private static int array[];
    EditText arraySize;
    RadioGroup rgCase;
    TextView tvBubble;
    TextView tvQuick;
    TextView tvInsertion;
    TextView tvSelection;
    TextView tvMerge;

    public void generateArray(View view){

        int size= 0;
        try {
            size = Integer.parseInt(arraySize.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        array= new int[size];

        switch (rgCase.getCheckedRadioButtonId()){
            case R.id.rbBest:
                array=Calculator.arrayOfNatural(size);
                Toast.makeText(this,"Array Generated of "+size+" sIze",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbAvg:
                array=Calculator.arrayRandom(size);
                Toast.makeText(this,"Array Generated of "+size+" sIze",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbWorst:
                array=Calculator.arrayReverse(size);
                Toast.makeText(this,"Array Generated of "+size+" sIze",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void generateCase(View view){
        try {
            switch (view.getId()) {
                case R.id.btnBubble:
                    int arr[] = Calculator.cloneArray(array);
                    long bStart = System.currentTimeMillis();
                    Calculator.bubble(arr);
                    long bEnd = System.currentTimeMillis();
                    tvBubble.setText("" + (bEnd - bStart) + " ms");
                    break;
                case R.id.btnSelection:
                    int arr2[] = Calculator.cloneArray(array);
                    long sStart = System.currentTimeMillis();
                    Calculator.selection(arr2);
                    long sEnd = System.currentTimeMillis();
                    tvSelection.setText("" + (sEnd - sStart) + " ms");
                    break;
                case R.id.btnQuick:
                    int arr3[] = Calculator.cloneArray(array);
                    long qStart = System.currentTimeMillis();
                    Calculator.quickSort(arr3, 0, arr3.length - 1);
                    long qEnd = System.currentTimeMillis();
                    tvQuick.setText("" + (qEnd - qStart) + " ms");
                    break;
                case R.id.btnMerge:
                    int arr4[] = Calculator.cloneArray(array);
                    long mStart = System.currentTimeMillis();
                    Calculator.mergeSort(arr4, 0, arr4.length);
                    long mEnd = System.currentTimeMillis();
                    tvMerge.setText("" + (mEnd - mStart) + " ms");
                    break;
                case R.id.btnInsert:
                    int arr5[] = Calculator.cloneArray(array);
                    long iStart = System.currentTimeMillis();
                    Calculator.insertion(arr5);
                    long iEnd = System.currentTimeMillis();
                    tvInsertion.setText("" + (iEnd - iStart) + " ms");
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void benchMarker(View view){
        int arr[]=Calculator.cloneArray(array);
        long bStart=System.currentTimeMillis();
        Calculator.bubble(arr);
        long bEnd=System.currentTimeMillis();
        tvBubble.setText(""+(bEnd-bStart)+ " ms");

        int arr2[]=Calculator.cloneArray(array);
        long sStart=System.currentTimeMillis();
        Calculator.bubble(arr2);
        long sEnd=System.currentTimeMillis();
        tvSelection.setText(""+(sEnd-sStart)+ " ms");

        int arr3[]=Calculator.cloneArray(array);
        long qStart=System.currentTimeMillis();
        Calculator.bubble(arr3);
        long qEnd=System.currentTimeMillis();
        tvQuick.setText(""+(qEnd-qStart)+" ms");

        int arr4[]=Calculator.cloneArray(array);
        long mStart=System.currentTimeMillis();
        Calculator.bubble(arr4);
        long mEnd=System.currentTimeMillis();
        tvMerge.setText(""+(mEnd-mStart)+" ms");

        int arr5[]=Calculator.cloneArray(array);
        long iStart=System.currentTimeMillis();
        Calculator.bubble(arr5);
        long iEnd=System.currentTimeMillis();
        tvInsertion.setText(""+(iEnd-iStart)+" ms");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benchmark_layout);
        arraySize= (EditText) findViewById(R.id.etSize);
        rgCase= (RadioGroup) findViewById(R.id.rgCase);
        tvBubble= (TextView) findViewById(R.id.tvBubble);
        tvInsertion= (TextView) findViewById(R.id.tvInsertion);
        tvSelection= (TextView) findViewById(R.id.tvSelection);
        tvMerge= (TextView) findViewById(R.id.tvMerge);
        tvQuick= (TextView) findViewById(R.id.tvQuick);
    }

}
