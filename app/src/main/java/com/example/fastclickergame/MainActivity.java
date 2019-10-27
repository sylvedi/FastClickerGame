package com.example.fastclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b_start,b_click1, b_click2;

    TextView tv_timeLeft, tv_Clicks;
    int numberOfClicks = 0;
    int SecondsLeft = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_start = (Button) findViewById(R.id.b_start);
        b_click1 = (Button) findViewById(R.id.b_click1);
        b_click2 = (Button) findViewById(R.id.b_click2);

        tv_timeLeft = (TextView) findViewById(R.id.tv_timeLeft);
        tv_Clicks = (TextView) findViewById(R.id.tv_Clicks);

        final CountDownTimer timer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                SecondsLeft--;
                tv_timeLeft.setText("Seconds left: " + SecondsLeft);
            }

            @Override
            public void onFinish() {
            b_click1.setEnabled(false);
            b_click2.setEnabled(false);
            }
        };

        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            SecondsLeft=20;
            numberOfClicks = 0;
            b_click1.setEnabled(true);
            b_click2.setEnabled(false);
            timer.start();
            }
        });


        b_click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfClicks++;
                tv_Clicks.setText("Number of Clicks: " + numberOfClicks);
                b_click2.setEnabled(true);
                b_click1.setEnabled(false);
            }
        });


        b_click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfClicks++;
                tv_Clicks.setText("Number of Clicks: " + numberOfClicks);
                b_click1.setEnabled(true);
                b_click2.setEnabled(false);
            }
        });
    }
}
