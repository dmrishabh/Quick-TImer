package com.example.examtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.telephony.emergency.EmergencyNumber;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    MediaPlayer m1;
    TextView number,done;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=findViewById(R.id.mnumber);
        done = findViewById(R.id.done);
        m1 = MediaPlayer.create(this,R.raw.timer);
        b1 = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(30000,1000){

                    public void onTick(long millisecondsUntilDone){
                        number.setText(String.valueOf(millisecondsUntilDone/1000));
                    }

                    public void onFinish() {
                        done.setText("Done!!");
                        m1.start();
                    }

                }.start();


                b1.setEnabled(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b1.setEnabled(true);

                    }
                },30000);

            }
        });

    }
}