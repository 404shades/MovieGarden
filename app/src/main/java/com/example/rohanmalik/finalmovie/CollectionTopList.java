package com.example.rohanmalik.finalmovie;

/**
 * Created by Rohan Malik on 01-08-2017.
 */

public class CollectionTopList {
    String name;
    String overview;
    String thumbnail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public CollectionTopList(String name, String overview, String thumbnail) {
        this.name = name;
        this.overview = overview;
        this.thumbnail = thumbnail;
    }
}
