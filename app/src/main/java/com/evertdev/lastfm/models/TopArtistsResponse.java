package com.evertdev.lastfm.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Evert Dev.
 */

public class TopArtistsResponse {
    @SerializedName("topartists")
    private TopArtists topArtists;

    public TopArtists getTopartists() {
        return topArtists;
    }

    public void setTopartists(TopArtists topArtists) {
        this.topArtists = topArtists;
    }
}
