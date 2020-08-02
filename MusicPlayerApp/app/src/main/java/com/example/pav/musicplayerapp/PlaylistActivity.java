package com.example.pav.musicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.AbstractQueue;
import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        Button goToNowPlaying = (Button) findViewById(R.id.now_playing_button);
        goToNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Eminem","1 - Public Service Announcement 2000 (skit)"));
        songs.add(new Song("Eminem", "2 - Kill You"));
        songs.add(new Song("Eminem", "3 - Stan (featuring Dido)"));
        songs.add(new Song("Eminem", "4 - Paul (skit)"));
        songs.add(new Song("Eminem", "5 - Who Knew"));
        songs.add(new Song("Eminem", "6 - Steve Berman (skit)"));
        songs.add(new Song("Eminem", "7 - The Way I Am"));
        songs.add(new Song("Eminem", "8 - The Real Slim Shady"));
        songs.add(new Song("Eminem", "9 - Remember Me? (featuring RBX & Sticky Fingaz)"));
        songs.add(new Song("Eminem", "10 - I'm Back"));
        songs.add(new Song("Eminem", "11 - Marshall Mathers"));
        songs.add(new Song("Eminem", "12 - Ken Kaniff (skit)"));
        songs.add(new Song("Eminem", "13 - Drug Ballad (featuring Dina Rae)"));
        songs.add(new Song("Eminem", "14 - Amityville (featuring Bizarre)"));
        songs.add(new Song("Eminem", "15 - Bitch Please II (featuring Dr. Dre, Snoop Dogg, Xzibit & Nate Dogg)"));
        songs.add(new Song("Eminem", "16 - Kim"));
        songs.add(new Song("Eminem", "17 - Under the Influence (featuring D12)"));
        songs.add(new Song("Eminem", "18 - Criminal"));
        songs.add(new Song("Eminem", "19 - The Kids (UK bonus track)"));

        SongAdapter songAdapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String nowPlayingString = songs.get(position).getmArtistName() + " - " + songs.get(position).getmSongName();
                    Intent viewNowPlayingIntent = new Intent(PlaylistActivity.this, NowPlaying.class);
                    viewNowPlayingIntent.putExtra("nowPlayingString", nowPlayingString);
                    startActivity(viewNowPlayingIntent);
            }
        });
    }
}
