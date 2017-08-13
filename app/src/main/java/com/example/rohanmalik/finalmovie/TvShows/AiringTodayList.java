package com.example.rohanmalik.finalmovie.TvShows;

/**
 * Created by Rohan Malik on 03-08-2017.
 */

public class AiringTodayList {
    String OriginalName;
    long id;
    String name;
    double voteAverage;
    String poster;

    public AiringTodayList(double voteAverage, String poster,long id) {
        this.voteAverage = voteAverage;
        this.poster = poster;
        this.id=id;
    }

    public String getOriginalName() {
        return OriginalName;
    }

    public void setOriginalName(String originalName) {
        OriginalName = originalName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
