package com.example.rohanmalik.finalmovie.MoviesTab;

/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class SimilarList {
    private String poster_path;
    private String title;
    private double avg;

    public SimilarList(String poster_path, String title, double avg) {
        this.poster_path = poster_path;
        this.title = title;
        this.avg = avg;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}
