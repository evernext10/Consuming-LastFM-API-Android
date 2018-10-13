package com.evertdev.lastfm.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Evert Dev.
 */

public class TopAlbumsResponse {
    public TopAlbums getTopAlbums() {
        return topAlbums;
    }

    public void setTopAlbums(TopAlbums topAlbums) {
        this.topAlbums = topAlbums;
    }

    @SerializedName("topalbums")
    TopAlbums topAlbums;
}
