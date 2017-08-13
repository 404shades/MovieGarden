package com.example.rohanmalik.finalmovie.model;

/**
 * Created by Rohan Malik on 06-08-2017.
 */

public class Vido {
    private String key;
    private String type;

    public Vido(String key, String type) {
        this.key = key;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
