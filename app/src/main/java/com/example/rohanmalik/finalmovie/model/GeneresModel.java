package com.example.rohanmalik.finalmovie.model;

import java.util.List;

/**
 * Created by Rohan Malik on 02-08-2017.
 */

public class GeneresModel {
    private List<GeneresCo> genres;

    public GeneresModel(List<GeneresCo> genres) {
        this.genres = genres;
    }

    public List<GeneresCo> getGenres() {
        return genres;
    }

    public void setGenres(List<GeneresCo> genres) {
        this.genres = genres;
    }
}
