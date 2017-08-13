package com.example.rohanmalik.finalmovie.model;

import java.util.List;

/**
 * Created by Rohan Malik on 06-08-2017.
 */

public class VideoYou {
    private List<Vido> results;

    public VideoYou(List<Vido> results) {
        this.results = results;
    }

    public List<Vido> getResults() {
        return results;
    }

    public void setResults(List<Vido> results) {
        this.results = results;
    }
}
