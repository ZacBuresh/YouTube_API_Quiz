package com.example.sam01.buresh_a6;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

//Author: Zachary Buresh
//Date: 11/5/2018
//Description: This program uses the YouTube Viewer API to retrieve a YouTube video from its URL.
//             The program quizzes the user on questions regarding each video.

public class MainActivity extends YouTubeBaseActivity {

    Button btnA, btnB, btnC, btnD, play;
    YouTubePlayerView video;
    YouTubePlayer.OnInitializedListener listener;
    TextView question, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        video = findViewById(R.id.video);
        play = findViewById(R.id.play);
        question = findViewById(R.id.question);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        message = findViewById(R.id.message);

        question.setText("Which Nickelodeon show is featured in this video?");
        btnA.setText("SpongeBob SquarePants");
        btnB.setText("The Fairly OddParents");
        btnC.setText("The Adventures of Jimmy Neutron");
        btnD.setText("Danny Phantom");

        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("7OZmRQkg9G0");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.initialize("AlzaSyC2GcfSaZhgmsBE7XrOfmagOvRPRfasSEs", listener);
            }
        });
    }

    public void hitA(View view) {
        btnA.setEnabled(false);
        message.setText("WRONG!");
        message.setTextColor(Color.parseColor("Red"));
    }

    public void hitB(View view) {
        //Move to next question Activity
        message.setText("CORRECT!");
        message.setTextColor(Color.parseColor("Green"));
    }

    public void hitC(View view) {
        btnC.setEnabled(false);
        message.setText("WRONG!");
        message.setTextColor(Color.parseColor("Red"));
    }

    public void hitD(View view) {
        btnD.setEnabled(false);
        message.setText("WRONG!");
        message.setTextColor(Color.parseColor("Red"));
    }
}
