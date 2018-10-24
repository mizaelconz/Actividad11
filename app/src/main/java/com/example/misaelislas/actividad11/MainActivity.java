package com.example.misaelislas.actividad11;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        mVideoView = findViewById(R.id.videoview);

        //Set Video View to Media Controller
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(mVideoView);

        //Set Media Controller to Video View
        mVideoView.setMediaController(controller);
    }

    private void initializePlayer(){
        mVideoView.setVideoPath("https://www.ebookfrenzy.com/android_book/movie.mp4");
        mVideoView.start();
    }

    private void releasePlayer() {mVideoView.stopPlayback();}


    @Override
    protected void onStop(){
        super.onStop();
        releasePlayer();
    }

    @Override
    protected void onPause(){
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N)
        {
            mVideoView.pause();
        }
    }
}