package com.example.rohanmalik.finalmovie.model;

import java.util.List;

/**
 * Created by Rohan Malik on 01-08-2017.
 */

public class populatTvShowsResponse {
    private Integer page;
    private Integer total_results;
    private Integer total_pages;
    private List<popularTvShows> results;

    public populatTvShowsResponse(Integer page, Integer total_results, Integer total_pages, List<popularTvShows> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public List<popularTvShows> getResults() {
        return results;
    }

    public void setResults(List<popularTvShows> results) {
        this.results = results;
    }
}
