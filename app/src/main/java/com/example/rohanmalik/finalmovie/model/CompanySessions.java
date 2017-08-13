package com.example.rohanmalik.finalmovie.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rohan Malik on 31-07-2017.
 */

public class CompanySessions {
    @SerializedName("adult")
    private Boolean Adult_Content;
    @SerializedName("backdrop_path")
    private String Back;
    @SerializedName("genre_ids")
    private List<Integer> genere;
    @SerializedName("id")
    private Integer id;
    @SerializedName("original_language")
    private String Language;
    private String original_title;
    private String overview;
    private String release_date;
    private String poster_path;
    private Float popularity;
    private String title;
    private Boolean video;
    private Double vote_average;
    private Long vote_count;

    public CompanySessions(Boolean adult_Content, String back, List<Integer> genere, Integer id, String language, String original_title, String overview, String release_date, String poster_path, Float popularity, String title, Boolean video, Double vote_average, Long vote_count) {
        Adult_Content = adult_Content;
        Back = back;
        this.genere = genere;
        this.id = id;
        Language = language;
        this.original_title = original_title;
        this.overview = overview;
        this.release_date = release_date;
        this.poster_path = poster_path;
        this.popularity = popularity;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public Boolean getAdult_Content() {
        return Adult_Content;
    }

    public void setAdult_Content(Boolean adult_Content) {
        Adult_Content = adult_Content;
    }

    public String getBack() {
        return Back;
    }

    public void setBack(String back) {
        Back = back;
    }

    public List<Integer> getGenere() {
        return genere;
    }

    public void setGenere(List<Integer> genere) {
        this.genere = genere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public Long getVote_count() {
        return vote_count;
    }

    public void setVote_count(Long vote_count) {
        this.vote_count = vote_count;
    }
}
