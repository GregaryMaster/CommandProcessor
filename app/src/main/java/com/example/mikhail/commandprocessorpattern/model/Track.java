package com.example.mikhail.commandprocessorpattern.model;

/**
 * Created by Mikhail on 19.07.2015.
 */
public class Track implements Result{

    private int trackId_;
    private String title_;
    private String description_;
    // The duration of track in min
    private int duration_;
    // The length of track in km
    private int length_;
    // The rating from 1 to 5

    // Icon for track
    private byte[] icon_;

    public Track(int id, String title, String description, int duration, int length, byte[] icon_) {
        this.trackId_ = id;
        this.title_ = title;
        this.description_ = description;
        this.duration_ = duration;
        this.length_ = length;
        this.icon_ = icon_;
    }

    public Track(int id, String title, String description, int duration, int length) {
        this.trackId_ = id;
        this.title_ = title;
        this.description_ = description;
        this.duration_ = duration;
        this.length_ = length;

    }

    public int getTrackId() {
        return trackId_;
    }

    public void setTrackId(int trackId_) {
        this.trackId_ = trackId_;
    }


    public String getTitle() {
        return title_;
    }

    public void setTitle(String title) {
        this.title_ = title;
    }

    public String getDescription() {
        return description_;
    }

    public void setDescription(String description) {
        this.description_ = description;
    }

    public int getDuration() {
        return duration_;
    }

    public void setDuration(int duration) {
        this.duration_ = duration;
    }

    public int getLength() {
        return length_;
    }

    public void setLength(int length) {
        this.length_ = length;
    }


    public byte[] getIcon() {
        return icon_;
    }

    public void setIcon_(byte[] icon_) {
        this.icon_ = icon_;
    }

}
