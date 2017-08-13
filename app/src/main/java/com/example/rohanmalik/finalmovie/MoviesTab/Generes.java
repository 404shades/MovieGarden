package com.example.rohanmalik.finalmovie.MoviesTab;

/**
 * Created by Rohan Malik on 02-08-2017.
 */

public class Generes {
    private int id;
    private String name;

    public Generes(int id, String name) {
        this.id = id;
        this.name = name;
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
}

