package com.evertdev.lastfm.ui.topalbumslisting;

import com.evertdev.lastfm.models.TopAlbumsResponse;

import io.reactivex.Single;

/**
 * Created by Evert Dev.
 */

public interface TopAlbumsInteractor {
    Single<TopAlbumsResponse> getTopAlbums(String userName, int limit, String apiKey);
}
