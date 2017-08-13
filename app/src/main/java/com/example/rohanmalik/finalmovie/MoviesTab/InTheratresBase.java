package com.example.rohanmalik.finalmovie.MoviesTab;

/**
 * Created by Rohan Malik on 02-08-2017.
 */

public class InTheratresBase {
    String title;
    double voteAverage;
    String poster_path;
    String backdrop;
    long id;

    public InTheratresBase(double voteAverage, String poster_path,long id) {
        this.voteAverage = voteAverage;
        this.poster_path = poster_path;
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }
}
