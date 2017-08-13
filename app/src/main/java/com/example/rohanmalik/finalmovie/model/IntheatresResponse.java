package com.example.rohanmalik.finalmovie.model;

import java.util.List;

/**
 * Created by Rohan Malik on 02-08-2017.
 */

public class IntheatresResponse {
    private List<InTheatres> results;
    private int page;
    private int total_results;
    private int total_pages;

    public IntheatresResponse(List<InTheatres> results, int page, int total_results, int total_pages) {
        this.results = results;
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
    }

    public List<InTheatres> getResults() {
        return results;
    }

    public void setResults(List<InTheatres> results) {
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

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
