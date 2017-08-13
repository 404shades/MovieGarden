package com.example.rohanmalik.finalmovie.TvShows;

/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class TVSeasons {
    private String poster_path;
    private int SeasonNumber;

    public TVSeasons(String poster_path, int seasonNumber) {
        this.poster_path = poster_path;
        SeasonNumber = seasonNumber;
    }

    public int getSeasonNumber() {
        return SeasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        SeasonNumber = seasonNumber;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
