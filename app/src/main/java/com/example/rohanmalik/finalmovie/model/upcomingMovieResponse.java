package com.example.rohanmalik.finalmovie.model;

import java.util.List;

/**
 * Created by Rohan Malik on 02-08-2017.
 */

public class upcomingMovieResponse {
    private List<UpcomingMovie> results;
    private int page;
    private int total_results;

    public upcomingMovieResponse(List<UpcomingMovie> results, int page, int total_results) {
        this.results = results;
        this.page = page;
        this.total_results = total_results;
    }

    public List<UpcomingMovie> getResults() {
        return results;
    }

    public void setResults(List<UpcomingMovie> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

}
