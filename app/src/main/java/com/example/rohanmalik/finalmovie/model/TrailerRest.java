package com.example.rohanmalik.finalmovie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rohan Malik on 28-07-2017.
 */

public class TrailerRest {
    @SerializedName("id")
    private long id;
    @SerializedName("results")
    private List<popularMovieTrailers> result;

    public TrailerRest(long id, List<popularMovieTrailers> result) {
        this.id = id;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<popularMovieTrailers> getResult() {
        return result;
    }

    public void setResult(List<popularMovieTrailers> result) {
        this.result = result;
    }
}
