package com.evertdev.lastfm.ui.topartistslisting;

import com.evertdev.lastfm.models.TopArtistsResponse;

import io.reactivex.Single;

/**
 * Created by Evert Dev.
 */

public interface TopArtistsInteractor {
    Single<TopArtistsResponse> getTopArtists(String userName, int limit, String apiKey);
}
