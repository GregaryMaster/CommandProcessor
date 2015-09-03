package com.example.mikhail.commandprocessorpattern.model;

/**
 * Created by Mikhail on 21.07.2015.
 */
public class Place implements Result{
    private String title_;
    private String shortDescription_;
    private byte[] icon_;

    public Place(String title,String description){
        this.title_ = title;
        this.shortDescription_ = description;
    }

    public void setTitle(String title){
        this.title_ = title;
    }

    public String getTitle(){
        return this.title_;
    }

    public void setShortDescription(String description){
        this.shortDescription_ = description;
    }

    public String getShortDescription(){
        return this.shortDescription_;
    }

    public byte[] getIcon() {
        return icon_;
    }

    public void setIcon(byte[] icon) {
        this.icon_ = icon;
    }

}
