package com.example.rohanmalik.finalmovie.model;

/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class SimilarMovieModal {
    private String poster_path;
    private String title;
    private double vote_average;

    public SimilarMovieModal(String poster_path, String title, double vote_average) {
        this.poster_path = poster_path;
        this.title = title;
        this.vote_average = vote_average;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
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
}
