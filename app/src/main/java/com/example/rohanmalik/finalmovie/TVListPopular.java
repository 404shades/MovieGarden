package com.example.rohanmalik.finalmovie;

/**
 * Created by Rohan Malik on 01-08-2017.
 */

public class TVListPopular {
    String originalName;
    String poster;
    int id;
    double vote;
    String backDrop;

    public TVListPopular(String originalName, String poster, int id, double vote,String backDrop) {
        this.originalName = originalName;
        this.poster = poster;
        this.id = id;
        this.vote = vote;
        this.backDrop = backDrop;
    }

    public String getBackDrop() {
        return backDrop;
    }

    public void setBackDrop(String backDrop) {
        this.backDrop = backDrop;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }
}
