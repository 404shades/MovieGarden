package com.example.rohanmalik.finalmovie.model;

import java.util.List;

/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class Casts {
private List<castResult> cast;

    public Casts(List<castResult> cast) {
        this.cast = cast;
    }

    public List<castResult> getCast() {
        return cast;
    }

    public void setCast(List<castResult> cast) {
        this.cast = cast;
    }
}
