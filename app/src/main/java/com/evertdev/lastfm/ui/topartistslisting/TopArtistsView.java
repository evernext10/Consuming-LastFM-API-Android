package com.evertdev.lastfm.ui.topartistslisting;

import com.evertdev.lastfm.models.Artist;

import java.util.List;

/**
 * Created by Evert Dev.
 */

public interface TopArtistsView {
    void showProgress();

    void hideProgress();

    void updateData(List<Artist> topArtists);

    void showError();
    void showEmpty();
    void hidEmpty();

}
