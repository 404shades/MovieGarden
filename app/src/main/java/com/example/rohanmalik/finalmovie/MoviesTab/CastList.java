package com.example.rohanmalik.finalmovie.MoviesTab;

/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class CastList {
    String profile;
    String Character;
    String name;

    public CastList(String profile, String character, String name) {
        this.profile = profile;
        Character = character;
        this.name = name;
    }

    public CastList(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getCharacter() {
        return Character;
    }

    public void setCharacter(String character) {
        Character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
