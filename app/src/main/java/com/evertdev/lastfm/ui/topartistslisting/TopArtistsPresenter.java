package com.evertdev.lastfm.ui.topartistslisting;

/**
 * Created by Evert Dev.
 */

public interface TopArtistsPresenter {
    void onDestroy();

    void getUserTopArtists(String userName, int limit, String apiKey);
}
