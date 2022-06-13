package com.antbps15545.reviewapp.models;

public class Song {

    private String mCode;
    private String mTitle;
    private String mLyric;
    private String mArtist;
    public Song() {
        // TODO something
    }

    public Song(String code, String title, String lyric, String artist) {
        this.mCode = code;
        this.mTitle = title;
        this.mLyric = lyric;
        this.mArtist = artist;
    }

    public String getCode() {
        return mCode;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getLyric() {
        return mLyric;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setCode(String code) {
        this.mCode = code;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setLyric(String lyric) {
        this.mLyric = lyric;
    }

    public void setArtist(String artist) {
        this.mArtist = artist;
    }

}
