package com.android.trellassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

import com.github.hiteshsondhi88.libffmpeg.FFmpeg;
import com.github.hiteshsondhi88.libffmpeg.LoadBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException;

public class BitRateSetActivity extends AppCompatActivity {

    SharedViewModel sharedViewModel;
    VideoView videoField;
    Button compress;
    FFmpeg ffmpeg ;
    EditText bitrate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_rate_set);
        sharedViewModel = ViewModelProviders.of(this).get(SharedViewModel.class);
        compress = (Button)findViewById(R.id.compress);
        videoField = (VideoView)findViewById(R.id.videoView);
        bitrate = (EditText)findViewById(R.id.bitrate);

        ffmpeg= FFmpeg.getInstance(getBaseContext());

        try {
            ffmpeg.loadBinary(new LoadBinaryResponseHandler() {

                @Override
                public void onStart() {}

                @Override
                public void onFailure() {}

                @Override
                public void onSuccess() {}

                @Override
                public void onFinish() {}
            });
        } catch (FFmpegNotSupportedException e) {
            // Handle if FFmpeg is not supported by device
        }

        compress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // assuming valid input
                sharedViewModel.setBitRate(Integer.parseInt(bitrate.getText().toString()));

                //change the bitrate to desired level
                changeBitRate(sharedViewModel.getBitRate());

                Intent intent = new Intent(getBaseContext(), VideoPlayActivity.class);
                startActivity(intent);
            }
        });


    }


    //TODO couldnt implement bitrate compression
    void changeBitRate(int bitrate) {

    }

}