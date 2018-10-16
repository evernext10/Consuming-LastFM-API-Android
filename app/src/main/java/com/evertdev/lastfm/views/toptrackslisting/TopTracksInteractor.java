package com.evertdev.lastfm.views.toptrackslisting;

import com.evertdev.lastfm.models.TopTracksResponse;

import io.reactivex.Single;

/**
 * Created by Evert Dev.
 */

public interface TopTracksInteractor {
    Single<TopTracksResponse> getTopTracks(String userName, int limit, String apiKey);

}
