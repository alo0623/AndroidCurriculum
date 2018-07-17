package com.alvinlo.cookieclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {
    int score;
    TextView scoreTextView;
    ImageView cookieImageView;

    public void clickCookie(View view){
       scoreTextView.setText("Score: " + String.valueOf(++score));
        Animation fadeOut = new AlphaAnimation(1f, 0f);
        fadeOut.setDuration(250);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        cookieImageView.startAnimation(fadeOut);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        cookieImageView = (ImageView) findViewById(R.id.cookieImageView);
    }
}
