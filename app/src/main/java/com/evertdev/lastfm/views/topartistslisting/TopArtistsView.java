package com.evertdev.lastfm.views.topartistslisting;

import com.evertdev.lastfm.models.Artist;

import java.util.List;

/**
 * Created by Evert Dev.
 */

public interface TopArtistsView {
    void showProgress();

    void hideProgress();

    void updateData(List<Artist> topArtists);
    void sqlitedata(List<Artist> topArtists);
    void showError();
    void showEmpty();
    void hidEmpty();

}
