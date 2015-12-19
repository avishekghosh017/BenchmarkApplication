package com.example.avigo.hellloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class JokesActivity extends Activity {
    ArrayList<String> arrayList=new ArrayList<String>();
    TextView tvJokes;
    TextView tvPage;
    static int i=0;
    int j=0;

    //EditText etJump=(EditText) findViewById(R.id.etJump);
    //int k=Integer.parseInt(etJump.getText().toString());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokes_layout);
        tvJokes=(TextView)findViewById(R.id.tvJokes);
        tvPage=(TextView) findViewById(R.id.tvPageNo);

        arrayList.add("My friend thinks he is smart.\n He told me an onion is the only food that makes you cry,\n so I threw a coconut at his face.");
        arrayList.add("I named my hard drive \"that ass,\" \n so once a month my computer asks if I want to \n \"back that ass up.\"");
        arrayList.add("Sardar joined new job. 1st day he worked till late evening on the computer.\n Boss was happy and asked what you did till evening.\n" +
                "Sardar: Keyboard alphabets were not in order, so I made it alright.");
        arrayList.add("Boss: Where were you born?\n" +
                "Sardar: India ..\n" +
                "Boss: which part?\n" +
                "Sardar: What 'which part'? Whole body was born in India .\n");
        arrayList.add("Banta: How the word 'Wife' was invented?\n" +
                "Santa: They took the first two and last two letters of 'Wildlife'!");
        arrayList.add("Why Hindu Law doesn't permit second marriage?\n" +
                "\n" +
                "Answer:- Indian Constitution article 20(2) says:\n\"No human can be punished twice for the same offence....");
        arrayList.add("I was confused when I read one of the girl's facebook status as, \n" +
                "\n" +
                "\"Bang Bang tomorrow night\"... Feeling Excited! - With Rahul and 12 others...\n" +
                "\n" +
                "I was more confused when her next status was ..haider was better.. ");

        tvJokes.setText(arrayList.get(0));
        tvPage.setText(""+(++j)+"/"+arrayList.size());
    }
    public void changeJokes(View view){
        switch (view.getId()){
            case R.id.ibNext:
                if(j==arrayList.size()){
                    Toast.makeText(this,"You Cannot Go Forward",Toast.LENGTH_SHORT).show();
                }else {
                    tvJokes.setText("" + arrayList.get(++i));
                    tvPage.setText("" + (++j) + "/" + arrayList.size());
                }
                break;
            case R.id.ibPrevious:
                if(j==1){
                    Toast.makeText(this,"You Cannot Go Back",Toast.LENGTH_SHORT).show();
                }else {
                    tvJokes.setText("" + arrayList.get(--i));
                    tvPage.setText("" + (--j) + "/" + arrayList.size());
                }
                break;
        }
    }
    /*
    public void jump(View view){
        switch (view.getId()){
            case R.id.etJump:
                if(k>=1 && k<=arrayList.size()){
                    tvJokes.setText(""+arrayList.get(k));
                    tvPage.setText(""+ k + "/" + arrayList.size());
                }
                break;
        }
    }
    */
}
