package com.android.trellassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class VideoPlayActivity extends AppCompatActivity {

    SharedViewModel sharedViewModel;
    VideoView videoField;
    Button play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        sharedViewModel = ViewModelProviders.of(this).get(SharedViewModel.class);
        play = (Button)findViewById(R.id.play);
        videoField = (VideoView)findViewById(R.id.videoViewPlay);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoField.setVideoURI(sharedViewModel.getVideo());
                videoField.start();
            }
        });

    }
}