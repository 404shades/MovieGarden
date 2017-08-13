package com.example.rohanmalik.finalmovie.model;

import java.util.List;

/**
 * Created by Rohan Malik on 01-08-2017.
 */

public class popularTvShows {
    private String original_name;
    private int id;
    private String name;
    private int vote_count;
    private Double vote_average;
    private String poster_path;
    private String first_air_date;
    private float popularity;
    private List<Integer> genre_ids;
    private String original_language;
    private String backdrop_path;
    private String overview;
    private List<String> origin_country;

    public popularTvShows(String original_name, int id, String name, int vote_count, Double vote_average, String poster_path, String first_air_date, float popularity, List<Integer> genre_ids, String original_language, String backdrop_path, String overview, List<String> origin_country) {
        this.original_name = original_name;
        this.id = id;
        this.name = name;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.poster_path = poster_path;
        this.first_air_date = first_air_date;
        this.popularity = popularity;
        this.genre_ids = genre_ids;
        this.original_language = original_language;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
        this.origin_country = origin_country;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }
}
