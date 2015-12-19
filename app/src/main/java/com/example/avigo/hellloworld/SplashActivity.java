package com.example.avigo.hellloworld;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        imageView=(ImageView) findViewById(R.id.ivLogo);
        textView=(TextView) findViewById(R.id.tvPromoText);

        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getBaseContext(),WindowsActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable,4000);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Animation animation=AnimationUtils.loadAnimation(getBaseContext(),R.anim.shake);
        imageView.startAnimation(animation);

        ObjectAnimator rotateAnimation = ObjectAnimator.ofFloat(textView, "rotation", 0,360,0,360,90,0);
        rotateAnimation.setDuration(3000);

        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(textView, "alpha", 0.5F, 0.9F, 0, 1.0F);
        alphaAnimation.setDuration(3000);

        ObjectAnimator moveXAnimation = ObjectAnimator.ofFloat(textView, "translationX", 0,100,0,-100,0, -100,0, -100);
        moveXAnimation.setDuration(2000);

        AnimatorSet set = new AnimatorSet();
        set.play(rotateAnimation).after(moveXAnimation).with(alphaAnimation);
        set.start();
    }
}
