package com.example.pav.musicplayerapp;

public class Song {

    private String mArtistName;
    private String mSongName;

    public Song (String artistName, String songName){
        mArtistName = artistName;
        mSongName = songName;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public String getmSongName() {
        return mSongName;
    }
}
