package com.example.rohanmalik.finalmovie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rohan Malik on 31-07-2017.
 */

public class Company {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String collection_name;
    @SerializedName("overview")
    private String overview;
    @SerializedName("poster_path")
    private String poster;
    @SerializedName("backdrop_path")
    private String Backdrop;
    @SerializedName("parts")
    private List<CompanySessions> Parts;

    public Company(Integer id, String collection_name, String overview, String poster, String backdrop, List<CompanySessions> parts) {
        this.id = id;
        this.collection_name = collection_name;
        this.overview = overview;
        this.poster = poster;
        Backdrop = backdrop;
        Parts = parts;
    }

    public String getCollection_name() {
        return collection_name;
    }

    public void setCollection_name(String collection_name) {
        this.collection_name = collection_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return Backdrop;
    }

    public void setBackdrop(String backdrop) {
        Backdrop = backdrop;
    }

    public List<CompanySessions> getParts() {
        return Parts;
    }

    public void setParts(List<CompanySessions> parts) {
        Parts = parts;
    }
}
