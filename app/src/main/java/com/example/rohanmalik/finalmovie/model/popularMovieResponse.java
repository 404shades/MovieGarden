package com.example.rohanmalik.finalmovie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rohan Malik on 28-07-2017.
 */

public class popularMovieResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<popularMovie> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public popularMovieResponse(int page, List<popularMovie> results, int totalResults, int totalPages) {
        this.page = page;
        this.results = results;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<popularMovie> getResults() {
        return results;
    }

    public void setResults(List<popularMovie> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
