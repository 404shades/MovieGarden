package com.example.rohanmalik.finalmovie.MoviesTab;

/**
 * Created by Rohan Malik on 02-08-2017.
 */

public class UpcomingMovieBase {
    String Title;
    int vote_average;
    String poster_path;
    String backdrop_path;
    String releaseDate;
    long id;

    public UpcomingMovieBase(String title, int vote_average, String poster_path, String backdrop_path, String releaseDate,long id) {
        Title = title;
        this.vote_average = vote_average;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.releaseDate = releaseDate;
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UpcomingMovieBase(String poster_path, String releaseDate,long id) {
        this.poster_path = poster_path;
        this.releaseDate = releaseDate;
        this.id=id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getVote_average() {
        return vote_average;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
}
