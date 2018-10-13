package com.evertdev.lastfm.ui.topalbumslisting;

import com.evertdev.lastfm.models.Album;

import java.util.List;

/**
 * Created by Evert Dev.
 */

public interface TopAlbumsView {
    void showProgress();

    void hideProgress();

    void showError();

    void updateData(List<Album> topAlbums);

    void showEmpty();

    void hidEmpty();
}
