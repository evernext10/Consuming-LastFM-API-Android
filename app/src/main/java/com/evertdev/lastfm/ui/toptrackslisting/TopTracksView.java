package com.evertdev.lastfm.ui.toptrackslisting;

import com.evertdev.lastfm.models.Track;

import java.util.List;

/**
 * Created by Evert Dev.
 */

public interface TopTracksView {
    void showProgress();
    void hideProgress();
    void showError();
    void updateData(List<Track> tracks);
    void showEmpty();
    void hidEmpty();
}
