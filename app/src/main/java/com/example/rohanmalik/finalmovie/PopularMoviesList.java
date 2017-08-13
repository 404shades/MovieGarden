package com.example.rohanmalik.finalmovie;

import java.util.Date;

/**
 * Created by Rohan Malik on 29-07-2017.
 */

public class PopularMoviesList {
    String thumbnail;
    String movie_Title;
    Double Rating;

    public PopularMoviesList(String thumbnail, String movie_Title, Double rating) {
        this.thumbnail = thumbnail;
        this.movie_Title = movie_Title;
        Rating = rating;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMovie_Title() {
        return movie_Title;
    }

    public void setMovie_Title(String movie_Title) {
        this.movie_Title = movie_Title;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }
}
