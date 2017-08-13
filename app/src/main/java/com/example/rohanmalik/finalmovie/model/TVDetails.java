package com.example.rohanmalik.finalmovie.model;

import java.util.List;

/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class TVDetails {
    private String backdrop_path;
    private List<CreatedTv> created_by;
    private List<GeneresCo> genres;
    private long id;
    private String name;
    private String overview;
    private String poster_path;
    private List<Seasons> seasons;
    private String last_air_date;
    private VideoYou videos;




    public String getLast_air_date() {
        return last_air_date;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public TVDetails(String backdrop_path, List<CreatedTv> created_by, List<GeneresCo> genres, long id, String name, String overview, String poster_path, List<Seasons> seasons, String last_air_date, VideoYou videos) {
        this.backdrop_path = backdrop_path;
        this.created_by = created_by;
        this.genres = genres;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.poster_path = poster_path;
        this.seasons = seasons;
        this.last_air_date = last_air_date;
        this.videos = videos;
    }

    public VideoYou getVideos() {
        return videos;
    }

    public void setVideos(VideoYou videos) {
        this.videos = videos;
    }

    public List<CreatedTv> getCreated_by() {
        return created_by;
    }

    public void setCreated_by(List<CreatedTv> created_by) {
        this.created_by = created_by;
    }

    public List<GeneresCo> getGenres() {
        return genres;
    }

    public void setGenres(List<GeneresCo> genres) {
        this.genres = genres;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<Seasons> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Seasons> seasons) {
        this.seasons = seasons;
    }
}
