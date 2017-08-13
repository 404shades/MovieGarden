package com.example.rohanmalik.finalmovie.model;

import java.util.List;

/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class MovieDetailsBase {
    private Boolean adult;
    private String backdrop_path;
    private String poster_path;
    private String original_title;
    private String release_date;
    private String tagline;
    private String overview;
    private List<GeneresCo> genres;
    private Casts casts;
    private Similar similar;

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public MovieDetailsBase(Boolean adult, String backdrop_path, String poster_path, String original_title, String release_date, String tagline, String overview, List<GeneresCo> genres, Casts casts, Similar similar) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.original_title = original_title;
        this.release_date = release_date;
        this.tagline = tagline;
        this.overview = overview;
        this.genres = genres;
        this.casts = casts;
        this.similar = similar;
    }

    public Similar getSimilar() {
        return similar;
    }

    public void setSimilar(Similar similar) {
        this.similar = similar;
    }

    public Casts getCasts() {
        return casts;
    }

    public void setCasts(Casts casts) {
        this.casts = casts;
    }

    public List<GeneresCo> getGenres() {
        return genres;
    }

    public void setGenres(List<GeneresCo> genres) {
        this.genres = genres;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
