package com.evertdev.lastfm.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Evert Dev.
 */

public class TopAlbums {
    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @SerializedName("album")
    List<Album> albums;
}
