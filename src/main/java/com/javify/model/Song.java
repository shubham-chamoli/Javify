package com.javify.model;

public class Song {
    private int id;
    private String title;
    private String artist;
    private String filePath;

    public Song(int id, String title, String artist, String filePath) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getFilePath() { return filePath; }
    
    // This is what shows up in the list if we don't style it
    @Override
    public String toString() { return title + " - " + artist; }
}