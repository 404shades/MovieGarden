package com.example.rohanmalik.finalmovie.model;

/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class Seasons {
    private String air_date;
    private String poster_path;
    private long id;
    private int season_number;

    public Seasons(String air_date, String poster_path, long id, int season_number) {
        this.air_date = air_date;
        this.poster_path = poster_path;
        this.id = id;
        this.season_number = season_number;
    }

    public int getSeason_number() {
        return season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
