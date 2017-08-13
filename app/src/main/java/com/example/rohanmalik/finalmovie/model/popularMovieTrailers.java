package com.example.rohanmalik.finalmovie.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rohan Malik on 28-07-2017.
 */

public class popularMovieTrailers {
        @SerializedName("id")
        private String ID;
    @SerializedName("iso_639_1")
    private String ISO_639_1;
    @SerializedName("iso_3166_1")
    private String ISO_3166_1;
    @SerializedName("key")
    private String KEy;
    @SerializedName("name")
    private String Name;
    @SerializedName("site")
    private String WEBSITE;
    @SerializedName("size")
    private String size;
    @SerializedName("type")
    private String type;

    public popularMovieTrailers(String ID, String ISO_639_1, String ISO_3166_1, String KEy, String name, String WEBSITE, String size, String type) {
        this.ID = ID;
        this.ISO_639_1 = ISO_639_1;
        this.ISO_3166_1 = ISO_3166_1;
        this.KEy = KEy;
        Name = name;
        this.WEBSITE = WEBSITE;
        this.size = size;
        this.type = type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getISO_639_1() {
        return ISO_639_1;
    }

    public void setISO_639_1(String ISO_639_1) {
        this.ISO_639_1 = ISO_639_1;
    }

    public String getISO_3166_1() {
        return ISO_3166_1;
    }

    public void setISO_3166_1(String ISO_3166_1) {
        this.ISO_3166_1 = ISO_3166_1;
    }

    public String getKEy() {
        return KEy;
    }

    public void setKEy(String KEy) {
        this.KEy = KEy;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getWEBSITE() {
        return WEBSITE;
    }

    public void setWEBSITE(String WEBSITE) {
        this.WEBSITE = WEBSITE;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
