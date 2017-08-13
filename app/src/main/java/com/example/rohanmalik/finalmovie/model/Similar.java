package com.example.rohanmalik.finalmovie.model;

import java.util.List;

/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class Similar {
    private int page;
    private List<SimilarMovieModal> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<SimilarMovieModal> getResults() {
        return results;
    }

    public void setResults(List<SimilarMovieModal> results) {
        this.results = results;
    }

    public Similar(int page, List<SimilarMovieModal> results) {
        this.page = page;
        this.results = results;
    }
}
