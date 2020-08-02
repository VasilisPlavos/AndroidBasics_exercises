package com.example.pav.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer soundMP = MediaPlayer.create(this, R.raw.cream);
        final Button playButton = (Button) this.findViewById(R.id.playButtonView);
        final Button pauseButton = (Button) this.findViewById(R.id.pauseButtonView);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundMP.start();
                Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                soundMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this, "WU FOREVER", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                soundMP.pause();
            }
        });

    }
}
