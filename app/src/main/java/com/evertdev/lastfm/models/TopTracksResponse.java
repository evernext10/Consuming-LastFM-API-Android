package com.evertdev.lastfm.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Evert Dev.
 */

public class TopTracksResponse {
    @SerializedName("toptracks")
    private TopTracks topTracks;

    public TopTracks getTopTracks() {
        return topTracks;
    }

    public void setToptracks(TopTracks topTracks) {
        this.topTracks = topTracks;
    }
}
