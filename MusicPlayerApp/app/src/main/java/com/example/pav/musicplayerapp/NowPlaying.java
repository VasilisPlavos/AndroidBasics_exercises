package com.example.pav.musicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent nowPlayingIntent;
        Button viewPlaylistButton = (Button) findViewById(R.id.viewPlaylist);

        nowPlayingIntent = getIntent();
        if (nowPlayingIntent.hasExtra("nowPlayingString")){
            String nowPlayingString = nowPlayingIntent.getExtras().getString("nowPlayingString");
            TextView nowPlayingTextView = (TextView) findViewById(R.id.nowPlaying);
            nowPlayingTextView.setText(nowPlayingString);
        }

        viewPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewPlaylistIntent = new Intent(NowPlaying.this, PlaylistActivity.class);
                startActivity(viewPlaylistIntent);
            }
        });
    }
}
